#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>

#pragma comment (lib, "OpenGL32.lib")

#define WINDOW_TITLE "GL Testing"
#define CW_USEDEFAULT 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define M_PI 3.141593

int sel = 1;
float xmove = 0, ymove = 0, rSpeed = 0, rSpeed2 = 0, tSpeed = 0.01, cT = .8, cSpeed = 0.003, sT = 0.0001;
float count = 0, count2 = 0;
LRESULT WINAPI WindowProcedure(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
	switch (msg)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	case WM_KEYDOWN:
		if (wParam == VK_ESCAPE) {
			PostQuitMessage(0);
		}
		else if (wParam == 0x31) {
			xmove = 0, ymove = 0;
			sel = 1;
		}
		else if (wParam == VK_LEFT) {
			xmove -= tSpeed;
		}
		else if (wParam == VK_RIGHT) {
			xmove += tSpeed;
		}
		else if (wParam == VK_UP) {
			ymove += tSpeed, rSpeed2 += 0.05;
		}
		else if (wParam == VK_DOWN) {
			ymove -= tSpeed, rSpeed2 -= 0.05;
		}
		else if (wParam == 0x32) {
			rSpeed2 = 0, sT = 0;
			sel = 2;
		}
		else if (wParam == 0x20) {
			xmove = 0, ymove = 0, rSpeed2 = 0, sT = 0;
		}
		break;
	default:
		break;
	}

	return DefWindowProc(hWnd, msg, wParam, lParam);
}
//--------------------------------------------------------------------

bool initPixelFormat(HDC hdc)
{
	PIXELFORMATDESCRIPTOR pfd;
	ZeroMemory(&pfd, sizeof(PIXELFORMATDESCRIPTOR));

	pfd.cAlphaBits = 8;
	pfd.cColorBits = 32;
	pfd.cDepthBits = 24;
	pfd.cStencilBits = 0;

	pfd.dwFlags = PFD_DOUBLEBUFFER | PFD_SUPPORT_OPENGL | PFD_DRAW_TO_WINDOW;

	pfd.iLayerType = PFD_MAIN_PLANE;
	pfd.iPixelType = PFD_TYPE_RGBA;
	pfd.nSize = sizeof(PIXELFORMATDESCRIPTOR);
	pfd.nVersion = 1;

	// choose pixel format returns the number most similar pixel format available
	int n = ChoosePixelFormat(hdc, &pfd);

	// set pixel format returns whether it sucessfully set the pixel format
	if (SetPixelFormat(hdc, n, &pfd))
	{
		return true;
	}
	else
	{
		return false;
	}
}
//--------------------------------------------------------------------

float xC(float x) {
	float xCoor, width = WIDTH / 2;
	if (x < width) {
		xCoor = (x / width) - 1;
	}
	else if (x > width) {
		xCoor = (x - width) / width;
	}
	else if (x == width) {
		xCoor = 0.0;
	}
	return xCoor;
}

float zC(float z) {
	float zCoor, depth = DEPTH / 2;
	/*if (z < 0) {
		zCoor = (z / depth);
	}
	else if (z > depth) {
		zCoor = (z - depth) / depth;
	}
	else if (z == depth) {
		zCoor = 0;
	}*/
	return (z / depth);
}

float yC(float y) {
	float yCoor, height = HEIGHT / 2;
	if (y < height) {
		yCoor = 1 - (y / height);
	}
	else if (y > height) {
		yCoor = 0 - ((y - height) / height);
	}
	else if (y == height) {
		yCoor = 0.0;
	}
	return yCoor;
}

float xP(float x) {
	return (x / (WIDTH / 2));
}

float yP(float y) {
	return (y / (HEIGHT / 2));
}

float zP(float z) {
	return (z / (DEPTH / 2));
}

float cC(float color) {
	return (color / 255);
}

void drawSphere(float xradius, float yradius, float zradius, int xaxis, int yaxis, float zaxis, float xmin, float xmax, float ymin, float ymax) {
	float i, j, lats = 100, longs = 100;
	float x2 = xC(xaxis), y2 = yC(yaxis), z2 = zC(zaxis);
	float xr = xP(xradius), yr = yP(yradius), zr = zP(zradius);

	for (i = xmin; i <= xmax; i++) {
		float lat0 = M_PI * (-0.5 + (i - 1) / lats);
		float z0 = sin(lat0);
		float zr0 = cos(lat0);

		float lat1 = M_PI * (-0.5 + i / lats);
		float z1 = sin(lat1);
		float zr1 = cos(lat1);

		glBegin(GL_POLYGON);
		for (j = ymin; j <= ymax; j++) {
			float lng = 2 * M_PI * (j - 1.0) / longs;
			float x = cos(lng);
			float y = sin(lng);

			glColor3f(1, 1, 1);
			//glNormal3f(x2 + x * zr0, y2 + y * zr0, z2 + z0);
			glVertex3f(x2 + xr * x * zr0, y2 + yr * y * zr0, z2 + zr * z0);

			glColor3f(1, 0, 0);
			//glNormal3f(x2 + x * zr1, y2 + y * zr1, z2 + z1);
			glVertex3f(x2 + xr * x * zr1, y2 + yr * y * zr1, z2 + zr * z1);
		}
		glEnd();
	}
}

void drawCircle(float x, float y, float xr, float yr, float min, float max) {
	//float z2;
	for (float i = min; i < max; i++)
	{
		float x2 = xC(x) + cos(i * M_PI / 180.f) * xP(xr);
		float y2 = yC(y) + sin(i * M_PI / 180.f) * yP(yr);
		glVertex2f(x2, y2);
	}
}

void quad(GLenum gltype, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
	glBegin(gltype);
	glVertex2f(x1, y1);
	glVertex2f(x2, y2);
	glVertex2f(x3, y3);
	glVertex2f(x4, y4);
	glEnd();
}

void obj() {
	glColor3f(1, 0, 0);
	quad(GL_QUADS, -.2, .1, -.2, -.1, .2, -.1, .2, .1);
}

void obj2() {
	glColor3f(1, 0, 1);
	quad(GL_QUADS, -.2, .1, -.2, -.1, .2, -.1, .2, .1);
}

void bezierQuad(float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4, float r, float g, float b) {
	float smoothness = 0.01;
	const int numberOfPoints = 500;
	float t;
	double xt[numberOfPoints], yt[numberOfPoints], xt2[numberOfPoints], yt2[numberOfPoints];
	float xD = 0, yD = 0;
	int i;

	float x5 = -x1, x6 = -x2, x7 = -x3, x8 = -x4;

	for (i = 0, t = 0; t <= 1.0; i++, t += smoothness) {
		// left
		xt[i] = pow((1 - t), 3) * x1 + 3 * t * pow((1 - t), 2) * x2 + 3 * pow(t, 2) * (1 - t) * x3 + pow(t, 3) * x4;
		yt[i] = pow((1 - t), 3) * y1 + 3 * t * pow((1 - t), 2) * y3 + 3 * pow(t, 2) * (1 - t) * y3 + pow(t, 3) * y4;
		// right
		xt2[i] = pow((1 - t), 3) * x5 + 3 * t * pow((1 - t), 2) * x6 + 3 * pow(t, 2) * (1 - t) * x7 + pow(t, 3) * x8;
	}

	glColor3f(0, 0, 0);
	glBegin(GL_QUAD_STRIP);
	for (i = 0; i < numberOfPoints; i++) {
		glVertex2f((xt[i] / 600) - xP(4), (yt[i] / 600));
		glVertex2f((xt2[i] / 600) + xP(3.5), (yt[i] / 600));
	}
	glEnd();

	glColor3f(r, g, b);
	glBegin(GL_QUAD_STRIP);
	for (i = 0; i < numberOfPoints; i++) {
		// left
		glVertex2f((xt[i] / 600), (yt[i] / 600));
		// right
		glVertex2f((xt2[i] / 600), (yt[i] / 600));
	}
	glEnd();
}

void drawBezier(GLenum type, float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4) {
	float smoothness = 0.02;
	const int numberOfPoints = 500;
	double xt[numberOfPoints], yt[numberOfPoints];
	float xD = 0, yD = 0;
	int i;
	float t;

	for (i = 0, t = 0; t <= 1.0; i++, t += smoothness) {
		xt[i] = pow((1 - t), 3) * x1 + 3 * t * pow((1 - t), 2) * x2 + 3 * pow(t, 2) * (1 - t) * x3 + pow(t, 3) * x4;
		yt[i] = pow((1 - t), 3) * y1 + 3 * t * pow((1 - t), 2) * y2 + 3 * pow(t, 2) * (1 - t) * y3 + pow(t, 3) * y4;
	}

	//glColor3f(1, 0, 0);
	glBegin(type);
	for (i = 0; i < numberOfPoints; i++) {
		glVertex2f((xt[i] / 600), (yt[i] / 600));
	}
	glEnd();
}

void wallpaper() {
	glColor3f(1, 1, 1);
	quad(GL_POLYGON, -1, 1, -1, -1, 1, -1, 1, 1);
}

void centerPoint() {
	glColor3f(cC(103), cC(70), cC(29));
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 10, 10, 0, 360);
	glEnd();

	glLineWidth(3);
	glColor3f(0, 0, 0);
	glBegin(GL_LINE_LOOP);
	drawCircle(400, 400, 10, 10, 1, 3600);
	glEnd();

	glPointSize(4);
	glColor3f(0, 0, 0);
	glBegin(GL_POINTS);
	glVertex2f(0, yC(400));
	glEnd();
}

void wing(float angle) {
	glPushMatrix();
	glTranslatef(0, yP(190), 0);
	glPushMatrix();
	glRotatef(-(angle + rSpeed), 0, 0, 1);
	
	glColor3f(cC(103), cC(70), cC(29));
	//stick
	quad(GL_POLYGON, xC(200), yC(395), xC(200), yC(405), xC(400), yC(405), xC(400), yC(395));
	glColor3f(0, 0, 0);
	quad(GL_LINE_LOOP, xC(200), yC(395), xC(200), yC(405), xC(400), yC(405), xC(400), yC(395));

	//frame
	glColor3f(cC(24), cC(118), cC(180));
	quad(GL_LINES, xC(205), yC(354), xC(205), yC(394), xC(380), yC(394), xC(380), yC(354));
	for (int i = 30; i <= 70; i += 20) {
		drawBezier(GL_LINE_STRIP, -30, -150, -150, -293, i, 20 + i, i - 20, i);
	}

	glPopMatrix();
	centerPoint();
	glPopMatrix();
}

void window(float xtr, float ytr) {
	glPushMatrix();
	glTranslatef(xtr, ytr, 0);
	// frame
	glColor3f(cC(0), cC(152), cC(255));
	quad(GL_QUADS, -0.05, 0.05, -0.05, -0.05, 0.05, -0.05, 0.05, 0.05);
	glLineWidth(2);
	glColor3f(0, 0, 0);
	quad(GL_LINE_LOOP, -0.05, 0.05, -0.05, -0.05, 0.05, -0.05, 0.05, 0.05);
	// line
	glBegin(GL_LINES);
	glVertex2f(-.05, 0);
	glVertex2f(.05, 0);
	glEnd();
	glBegin(GL_LINES);
	glVertex2f(0, .05);
	glVertex2f(0, -.05);
	glEnd();
	glPopMatrix();
}

void door() {
	glColor3f(cC(33), cC(102), cC(148));
	quad(GL_QUADS, xC(365), yC(570), xC(365), yC(669), xC(435), yC(669), xC(435), yC(570));
	glColor3f(0, 0, 0);
	quad(GL_LINE_LOOP, xC(365), yC(570), xC(365), yC(669), xC(435), yC(669), xC(435), yC(570));
	glLineWidth(2);
	quad(GL_LINE_LOOP, xC(369), yC(574), xC(369), yC(665), xC(431), yC(665), xC(431), yC(574));
	glColor3f(0, 0, 0);
	glBegin(GL_LINE_LOOP);
	drawCircle(380, 620, 3, 5, 0, 360);
	glEnd();
}

void roof(){
	bezierQuad(-200, -50, -200, 5, -150, 50, 150, 300, 1, 0, 0);
	glLineWidth(3);
	glColor3f(0, 0, 0);
	glBegin(GL_LINES);
	glVertex2f(xC(264), yC(500));
	glVertex2f(xC(535), yC(500));
	glEnd();

	drawBezier(GL_LINE_STRIP, -100, 0, -100, 5, -150, 50, 150, 300);
	drawBezier(GL_LINE_STRIP, 100, 0, 100, -5, -150, 50, 150, 300);

	window(0, 0.1);
}

void wall() {
	glColor3f(1, 1, 1);
	quad(GL_QUADS, xC(270), yC(501), xC(270), yC(670), xC(529), yC(670), xC(529), yC(501));
	glLineWidth(3);
	glColor3f(0, 0, 0);
	quad(GL_LINE_STRIP, xC(270), yC(501), xC(270), yC(670), xC(529), yC(670), xC(529), yC(501));
	window(0, -0.34);
	window(-0.23, -0.34);
	window(0.23, -0.34);
	door();
}

void sunHand(float angle) {
	glPushMatrix();
	glRotatef((angle + rSpeed + 1), 0, 0, 1);
	glTranslatef(0, yP(95), 0);
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(xC(400), yC(400));
	glColor3f(1, 0.7, 0);
	glVertex2f(xC(385), yC(420));
	glVertex2f(xC(415), yC(420));
	glEnd();
	glPopMatrix();
}

void sun() {
	glPushMatrix();
	glTranslatef(xC(700), (-0.2) + sT, 0);
	/*for (int angle = 360; 0 <= 360; angle += 45) {
		sunHand(45);
	}*/
	sunHand(0);
	sunHand(45);
	sunHand(90);
	sunHand(135);
	sunHand(180);
	sunHand(225);
	sunHand(270);
	sunHand(315);
	glColor3f(1, 1, 0);
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 60, 60, 0, 360);
	glEnd();
	glPopMatrix();
}

void cloud(float xx, float yy, float reverse, float reverse2) {
	glColor3f(.9, .9, .9);
	glPushMatrix();
	glTranslatef((reverse - (cT + xx)) * reverse2, .5 + yy, 0);
	glPushMatrix();
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 25, 25, 0, 360);
	glEnd();
	glPopMatrix();
	glPushMatrix();
	glTranslatef(xP(25), yP(20), 0);
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 25, 25, 0, 360);
	glEnd();
	glPopMatrix();
	glPushMatrix();
	glTranslatef(xP(60), yP(20), 0);
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 25, 25, 0, 360);
	glEnd();
	glPopMatrix();
	glPushMatrix();
	glTranslatef(xP(85), 0, 0);
	glBegin(GL_POLYGON);
	drawCircle(400, 400, 25, 25, 0, 360);
	glEnd();
	glPopMatrix();
	quad(GL_QUADS, xC(395), yC(390), xC(395), yC(425), xC(490), yC(425), xC(490), yC(390));
	glPopMatrix();
}

void mountain() {
	bezierQuad(-350, -200, -120, 5, -150, 50, 150, 230, 0, 0.5, 0);
}

void ground() {
	glColor3f(0.63, 0.52, 0.37);
	quad(GL_POLYGON, xC(0), yC(600), xC(0), yC(800), xC(800), yC(800), xC(800), yC(600));
}

void windmill() {
	glPushMatrix();
	roof();
	wall();
	
	for (int i = 0; i < 360; i += 90) {
		wing(i);
	}
	glPopMatrix();
	
}

void display()
{
	switch (sel) {
	case 1:
		glClearColor(0, 0, 0, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		glPushMatrix();
		glTranslatef(xmove, ymove, 0);
		obj();
		glPopMatrix();

		glPushMatrix();
		glTranslatef(-xmove, -ymove, 0);
		obj2();
		glPopMatrix();
		break;
	case 2:
		glClearColor(0.65, 0.89, 0.93, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		rSpeed += 0.3 + rSpeed2;
		count += 2;
		count2 += 1;

		if (count > 0 && count <= 1200) {
			cT -= cSpeed;
		}
		if (count > 1200 && count < 2400) {
			cT += cSpeed;
		}
		if (count >= 2400) {
			count = 0;
		}
		if (count2 > 0 && count2 <= 500) {
			sT += 0.002;
		}

		sun();

		cloud(0, 0, 0, -1);
		cloud(-1, -.2, -1, 1);
		
		// mountain 1
		glPushMatrix();
		glTranslatef(-.7, -.25, 0);
		mountain();
		glPopMatrix();

		// mountain 2
		glPushMatrix();
		glTranslatef(-.2, -.25, 0);
		mountain();
		glPopMatrix();

		// mountain 3
		glPushMatrix();
		glTranslatef(1.2, -.25, 0);
		mountain();
		glPopMatrix();

		// mountain 4
		glPushMatrix();
		glTranslatef(.5, -.4, 0);
		mountain();
		glPopMatrix();

		ground();
		glPushMatrix();
		glTranslatef(0, 0, 0);
		windmill();
		glPopMatrix();

		cloud(-1.5, .2, -1, 1);
		break;
	case 3:
		break;
	case 20:
		break;
	default:
		break;
	}
}
//--------------------------------------------------------------------

int WINAPI WinMain(HINSTANCE hInst, HINSTANCE, LPSTR, int nCmdShow)
{
	WNDCLASSEX wc;
	ZeroMemory(&wc, sizeof(WNDCLASSEX));

	wc.cbSize = sizeof(WNDCLASSEX);
	wc.hInstance = GetModuleHandle(NULL);
	wc.lpfnWndProc = WindowProcedure;
	wc.lpszClassName = WINDOW_TITLE;
	wc.style = CS_HREDRAW | CS_VREDRAW;

	if (!RegisterClassEx(&wc)) return false;

	HWND hWnd = CreateWindow(WINDOW_TITLE, WINDOW_TITLE, WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT, CW_USEDEFAULT, WIDTH, HEIGHT,
		NULL, NULL, wc.hInstance, NULL);

	//--------------------------------
	//	Initialize window for OpenGL
	//--------------------------------

	HDC hdc = GetDC(hWnd);

	//	initialize pixel format for the window
	initPixelFormat(hdc);

	//	get an openGL context
	HGLRC hglrc = wglCreateContext(hdc);

	//	make context current
	if (!wglMakeCurrent(hdc, hglrc)) return false;

	//--------------------------------
	//	End initialization
	//--------------------------------

	ShowWindow(hWnd, nCmdShow);

	MSG msg;
	ZeroMemory(&msg, sizeof(msg));

	while (true)
	{
		if (PeekMessage(&msg, NULL, 0, 0, PM_REMOVE))
		{
			if (msg.message == WM_QUIT) break;

			TranslateMessage(&msg);
			DispatchMessage(&msg);
		}

		display();

		SwapBuffers(hdc);
	}

	UnregisterClass(WINDOW_TITLE, wc.hInstance);

	return true;
}
//--------------------------------------------------------------------