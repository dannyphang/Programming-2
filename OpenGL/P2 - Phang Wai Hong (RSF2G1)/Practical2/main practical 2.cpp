#include <Windows.h>
#include <gl/gl.h>
#include <gl/glu.h>
#include <math.h>

#pragma comment (lib, "OpenGL32.lib")
#pragma comment (lib, "OpenGL32.lib")

#define WINDOW_TITLE "GL Testing"
#define CW_USEDEFAULT 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define M_PI 3.2

int num = 1;
float c1 = 0.1, c2 = 0.2, c3 = 0.3, c4 = 0.4, c5 = 0.5, c6 = 0.6;
float count = 0;
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
		if (wParam == 0x0031) {
			num = 1;
		}
		if (wParam == 0x0032) {
			num = 2;
		}
		if (wParam == 0x0033) {
			num = 3;
		}
		if (wParam == 0x0034) {
			num = 4;
		}
		if (wParam == 0x0025) { // left
			num = 25;
		}
		if (wParam == 0x0026) { // up
			num = 26;
		}
		if (wParam == 0x0027) { // right
			num = 27;
		}
		if (wParam == 0x0028) { // down
			num = 28;
		}
		if (wParam == 0x0052 || wParam == 0x0072) { // R / r
			num = 52;
		}
		if (wParam == 0x0047 || wParam == 0x0067) { // G / g
			num = 47;
		}
		if (wParam == 0x0042 || wParam == 0x0062) { // B / b
			num = 42;
		}
		if (wParam == 0x0020) { // space
			num = 20;
		}
		break;
	default:
		break;
	}

	return DefWindowProc(hWnd, msg, wParam, lParam);
}
//--------------------------------------------------------------------
void object() {

	glLineWidth(3);
	glBegin(GL_QUADS);
	glVertex2f(-0.2, 0.2);
	glVertex2f(-0.2, -0.2);
	glVertex2f(0.2, -0.2);
	glVertex2f(0.2, 0.2);
	glEnd();
}

void object2() {
	glClearColor(0, 0, 0, 0);
	glEnable(GL_DEPTH_TEST);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glBegin(GL_POLYGON);
	glColor3f(1, 0, 0.5);
	glVertex2f(-0.2, 0.2);
	glVertex2f(0.2, 0.2);
	glVertex2f(0.2, -0.2);
	glVertex2f(-0.2, -0.2);
	glEnd();
}

void star() {

	glBegin(GL_TRIANGLE_FAN);
	glColor3f(1, 1, 1);
	glVertex2f(0, 0);
	glColor3f(c1, c2, c3);
	glVertex2f(-0.4, 0);
	glColor3f(c2, c4, c6);
	glVertex2f(-0.2, 0.35);
	glColor3f(c4, c2, c3);
	glVertex2f(0.2, 0.35);
	glColor3f(c5, c2, c6);
	glVertex2f(0.4, 0);
	glColor3f(c1, c5, c6);
	glVertex2f(0.2, -0.35);
	glColor3f(c3, c5, c1);
	glVertex2f(-0.2, -0.35);
	glColor3f(c4, c2, c4);
	glVertex2f(-0.4, 0);
	glEnd();

}

void star2() {
	// 1
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(0, 0.7);
	glColor3f(c6, c2, c3);
	glVertex2f(-0.2, 0.35);
	glVertex2f(0.2, 0.35);
	glEnd();

	// 2
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(-0.6, 0.35);
	glColor3f(c2, c1, c3);
	glVertex2f(-0.4, 0);
	glVertex2f(-0.2, 0.35);
	glEnd();

	// 3
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(-0.6, -0.35);
	glColor3f(c1, c2, c4);
	glVertex2f(-0.2, -0.35);
	glVertex2f(-0.4, 0);
	glEnd();

	// 4
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(0, -0.7);
	glColor3f(c5, c2, c6);
	glVertex2f(-0.2, -0.35);
	glVertex2f(0.2, -0.35);
	glEnd();

	// 5
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(0.6, -0.35);
	glColor3f(c3, c4, c5);
	glVertex2f(0.2, -0.35);
	glVertex2f(0.4, 0);
	glEnd();

	// 6
	glBegin(GL_TRIANGLES);
	glColor3f(1, 1, 1);
	glVertex2f(0.6, 0.35);
	glColor3f(c6, c2, c1);
	glVertex2f(0.4, 0);
	glVertex2f(0.2, 0.35);
	glEnd();
}

void display()
{
	glClearColor(0, 0, 0, 0);
	glEnable(GL_DEPTH_TEST);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	float cc = 0.002;

	switch (num) {
	case 1:
		object();
		break;
	case 52: // red
		glColor3f(1, 0, 0);
		object();
		break;
	case 47: // green
		glColor3f(0, 1, 0);
		object();
		break;
	case 42: // blue
		glColor3f(0, 0, 1);
		object();
		break;
	case 20: // space to reset
		glColor3f(1, 1, 1);
		glLoadIdentity();
		object();
		break;
	case 25: // left
		glTranslatef(-0.005, 0, 0);
		object();
		break;
	case 26: // up
		glTranslatef(0, 0.005, 0);
		object();
		break;
	case 27: // right
		glTranslatef(0.005, 0, 0);
		object();
		break;
	case 28: // down
		glTranslatef(0, -0.005, 0);
		object();
		break;
	case 2: // change color
		count += 0.05;
		glColor3f(1, 1, 0);
		star();
		count += 2;
		if (count > 0 && count <= 100) {
			c1 += cc;
			c2 += cc;
			c3 += cc;
			c4 += cc;
			c5 += cc;
			c6 += cc;
		}
		if (count > 100 && count < 200) {
			c1 -= cc;
			c2 -= cc;
			c3 -= cc;
			c4 -= cc;
			c5 -= cc;
			c6 -= cc;
		}
		if (count >= 200) {
			count = 0;
		}
		star2();
		break;
	case 3: // rotate
		glPointSize(3);
		glColor3f(1, 0, 1);
		glRotatef(1, 0, 0, 1);
		glBegin(GL_POINTS);
		glVertex2f(0, -0.3);
		glEnd();
		break;
	case 4: // enlarge 
		glScalef(1.003f, 1.003f, 0.0f);
		object2();
		break;
	default:
		glLoadIdentity();
		object();
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