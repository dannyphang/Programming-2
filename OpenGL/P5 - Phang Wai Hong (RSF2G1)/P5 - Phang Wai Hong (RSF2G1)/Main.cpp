#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>
#include <iostream>

#define WINDOW_TITLE "GL Practical 5A"
#define CW 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define SIZE 15

int qNo = 1;
float rotate = 0;
LRESULT WINAPI WindowProcedure(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
	switch (msg) {
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	case WM_KEYDOWN:
		if (wParam == VK_ESCAPE) {
			PostQuitMessage(0);
		}
		else if (wParam == 0x31) {
			glLoadIdentity();
			qNo = 1;
		}
		else if (wParam == 0x32) {
			glLoadIdentity();
			qNo = 2;
		}
		else if (wParam == VK_SPACE) {
			glLoadIdentity();
		}
		else if (wParam == 0x33) {
			glLoadIdentity();
			qNo = 3;
		}
		else if (wParam == 0x34) {
			qNo = 4;
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

	// choose pixel format returns the rotateAngleber most similar pixel format available
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

void cone() {
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glColor3f(0.60, 0.40, 0.20);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluCylinder(cyl, 0.0, 0.2, 0.5, 20, 10);

	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(cyl, GLU_LINE);
	gluCylinder(cyl, 0.0, 0.2, 0.5, 20, 10);

	gluDeleteQuadric(cyl);
	glPopMatrix();
}

void ball() {
	GLUquadricObj* ball1 = NULL;
	ball1 = gluNewQuadric();

	glPushMatrix();
	glTranslatef(0, 0.3, 0);
	glColor3f(0.00, 0.80, 0.20);
	gluQuadricDrawStyle(ball1, GLU_FILL);
	gluSphere(ball1, 0.185, 30, 30);
	gluDeleteQuadric(ball1);
	glPopMatrix();
}

void ball2() {
	GLUquadricObj* ball1 = NULL;
	ball1 = gluNewQuadric();
	glPushMatrix();
	glTranslatef(0, 0.55, 0);
	glColor3f(0.85, 0.85, 0.85);
	gluQuadricDrawStyle(ball1, GLU_FILL);
	gluSphere(ball1, 0.185, 30, 30);

	gluDeleteQuadric(ball1);
	glPopMatrix();
}

void cherry() {
	GLUquadricObj* cherry = NULL;
	cherry = gluNewQuadric();
	glPushMatrix();
	glTranslatef(0.14, 0.67, 0);
	glColor3f(1, 0, 0);
	gluQuadricDrawStyle(cherry, GLU_FILL);
	gluSphere(cherry, 0.05, 30, 30);
	gluDeleteQuadric(cherry);

	glBegin(GL_LINE_STRIP);
	glVertex3f(0, 0, 0);
	glVertex3f(0.07, 0.06, 0);
	glVertex3f(0.1, 0.07, 0);
	glEnd();
	glPopMatrix();
}

void biskut() {
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glTranslatef(0, 0.6, 0);
	glRotatef(-25, 0, 0, 1);
	glTranslatef(0, -0.25, 0);
	glRotatef(-90, 1, 0, 0);
	glColor3f(0.40, 0.20, 0.00);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluCylinder(cyl, 0.03, 0.03, 0.5, 30, 10);
	glColor3f(0, 0, 0);
	gluQuadricDrawStyle(cyl, GLU_LINE);
	gluCylinder(cyl, 0.03, 0.03, 0.5, 10, 2);
	gluDeleteQuadric(cyl);
	glPopMatrix();
}

void display()
{
	glClearColor(0, 0, 0, 0);
	glEnable(GL_DEPTH_TEST);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	rotate += 0.5;

	glPushMatrix();
	glRotatef(-10, 1, 0, 0);
	glRotatef(rotate, 0, 1, 0);

	biskut();
	cherry();
	ball();
	ball2();

	glTranslatef(0, -0.25, 0);
	glRotatef(-90, 1, 0, 0);
	cone();
	glPopMatrix();
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
		CW, CW, WIDTH, HEIGHT,
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