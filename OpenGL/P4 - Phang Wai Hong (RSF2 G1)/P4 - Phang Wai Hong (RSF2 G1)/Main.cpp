#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>
#include <iostream>
#include "Function.h"

using namespace N;

#pragma comment (lib, "OpenGL32.lib")

#define WINDOW_TITLE "GL Testing"
#define CW 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE

function fh;
int qNo = 2, x = 0, y = 0, z = 0, x2 = 0, y2 = 0, z2 = 0;
float rSpeed = 1, r2 = 0, r_ing = 0, r_ing2 = 0;
int count = 0;
char key = NULL;
float AR = 0;

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
		else if (wParam == VK_LEFT) {
			r_ing2 += rSpeed;
		}
		else if (wParam == VK_RIGHT) {
			r_ing2 -= rSpeed;
		}
		else if (wParam == VK_UP) {
			if (count == 0) {
				count = 1;
			}
			key = 'u';
		}
		else if (wParam == VK_DOWN) {
			key = 'd';
		}
		else if (wParam == 0x32) {
			glLoadIdentity();
			qNo = 2;
		}
		else if (wParam == VK_SPACE) {
			glLoadIdentity();
			r2 = 0, AR = 0, count = 0;
			r_ing = 0, r_ing2 = 0;
			//count = 1;
		}
		else if (wParam == 0x58) {
			// x
			x = 1, y = 0, z = 0, r2 = rSpeed;
		}
		else if (wParam == 0x59) {
			// y
			x = 0, y = 1, z = 0, r2 = rSpeed;
		}
		else if (wParam == 0x5A) {
			// z
			x = 0, y = 0, z = 1, r2 = rSpeed;
		}
		else if (wParam == 0x50) {
			key = 'p';
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

void pyramid() {
	glLineWidth(2);

	//front
	glColor3f(1, 0, 0);
	glBegin(GL_LINE_LOOP);
	fh.v3(0, .2, 0);
	fh.v3(-.23, -.2, -.23);
	fh.v3(.23, -.2, -.23);

	glEnd();
	
	// left
	glColor3f(1, 1, 0);
	glBegin(GL_LINE_LOOP);
	fh.v3(0, .2, 0);
	fh.v3(-.23, -.2, -.23);
	fh.v3(-.23, -.2, .23);
	glEnd();

	// right
	glColor3f(1, 1, 1);
	glBegin(GL_LINE_LOOP);
	fh.v3(0, .2, 0);
	fh.v3(.23, -.2, -.23);
	fh.v3(.23, -.2, .23);
	glEnd();

	// back
	glColor3f(1, 0, 1);
	glBegin(GL_LINE_LOOP);
	fh.v3(0, .2, 0);
	fh.v3(-.23, -.2, .23);
	fh.v3(.23, -.2, .23);
	glEnd();

	// base
	glColor3f(0, 1, 1);
	glBegin(GL_POLYGON);
	fh.v3(-.23, -.2, -.23);
	fh.v3(-.23, -.2, .23);
	fh.v3(.23, -.2, .23);
	fh.v3(.23, -.2, -.23);
	glEnd();
}

void arm1(GLenum type) {
	
	glLineWidth(3);
	// front
	glColor3f(1, 0, 0);
	glBegin(type);
	fh.v3(-.5, .125, .125);
	fh.v3(-.5, -.125, .125);
	fh.v3(0, -.125, .125);
	fh.v3(0, .125, .125);
	glEnd();

	// back
	glColor3f(0, 1, 0);
	glBegin(type);
	fh.v3(-.5, .125, -.125);
	fh.v3(-.5, -.125, -.125);
	fh.v3(0, -.125, -.125);
	fh.v3(0, .125, -.125);
	glEnd();

	// left
	glColor3f(1, 1, 0);
	glBegin(type);
	fh.v3(-.5, .125, -.125);
	fh.v3(-.5, -.125, -.125);
	fh.v3(-.5, -.125, .125);
	fh.v3(-.5, .125, .125);
	glEnd();

	// right
	glColor3f(1, 1, 1);
	glBegin(type);
	fh.v3(0, .125, -.125);
	fh.v3(0, -.125, -.125);
	fh.v3(0, -.125, .125);
	fh.v3(0, .125, .125);
	glEnd();

	// top
	glColor3f(1, 0, 1);
	glBegin(type);
	fh.v3(-.5, .125, -.125);
	fh.v3(-.5, .125, .125);
	fh.v3(0, .125, .125);
	fh.v3(0, .125, -.125);
	glEnd();

	// btm
	glColor3f(0, 1, 1);
	glBegin(type);
	fh.v3(-.5, -.125, -.125);
	fh.v3(-.5, -.125, .125);
	fh.v3(0, -.125, .125);
	fh.v3(0, -.125, -.125);
	glEnd();
}

void arm2(GLenum type) {

	glLineWidth(3);
	// front
	glColor3f(1, 0, 0);
	glBegin(type);
	fh.v3(.5, .1, .1);
	fh.v3(.5, -.1, .1);
	fh.v3(0, -.125, .125);
	fh.v3(0, .125, .125);
	glEnd();

	// back
	glColor3f(0, 1, 0);
	glBegin(type);
	fh.v3(.5, .1, -.1);
	fh.v3(.5, -.1, -.1);
	fh.v3(0, -.125, -.125);
	fh.v3(0, .125, -.125);
	glEnd();

	// right
	glColor3f(1, 1, 0);
	//glBegin(type);
	glBegin(GL_POLYGON);
	fh.v3(.5, .1, -.1);
	fh.v3(.5, -.1, -.1);
	fh.v3(.5, -.1, .1);
	fh.v3(.5, .1, .1);
	glEnd();

	// left
	glColor3f(1, 1, 1);
	glBegin(type);
	fh.v3(0, .125, -.125);
	fh.v3(0, -.125, -.125);
	fh.v3(0, -.125, .125);
	fh.v3(0, .125, .125);
	glEnd();

	// top
	glColor3f(1, 0, 1);
	glBegin(type);
	fh.v3(.5, .1, -.1);
	fh.v3(.5, .1, .1);
	fh.v3(0, .125, .125);
	fh.v3(0, .125, -.125);
	glEnd();

	// btm
	glColor3f(0, 1, 1);
	glBegin(type);
	fh.v3(.5, -.1, -.1);
	fh.v3(.5, -.1, .1);
	fh.v3(0, -.125, .125);
	fh.v3(0, -.125, -.125);
	glEnd();
}

void forefinger() {

}

void fingers() {
	forefinger();
}

void display()
{
	glClearColor(0, 0, 0, 0);
	glEnable(GL_DEPTH_TEST);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	float xx, realAngle, ARSpeed, rotateAngle;

	switch (qNo) {
	case 1:
		glRotatef(r2, x, y, z);
		pyramid();
		break;
	case 2:
		realAngle = 135;
		ARSpeed = 0.5;
		rotateAngle = realAngle * (1 / ARSpeed);

		if (key == 'p') {
			count = count;
		}

		if (key == 'u') {
			if (count > 0 && count < rotateAngle && key != 'p') {
				++count;
				AR += ARSpeed;
			}
			if (count == rotateAngle) {
				count = rotateAngle;
			}
		}

		if (key == 'd') {
			if (count > 1 && count <= rotateAngle && key != 'p') {
				--count;
				AR -= ARSpeed;
			}
			if (count == 1) {
				count = 1;
			}
		}

		glPushMatrix();
		//glRotatef(270, 0, 1, 0);
		glRotatef(r_ing2, 1, 0, 0);
		//arm1(GL_LINE_LOOP);
		arm1(GL_POLYGON);

		glPushMatrix();
		fh.drawSphere(GL_LINE_LOOP, 48, 48, 48, 0, 0, 0, 0, 100, 0, 100, 1, 1, 1);
		glPopMatrix();

		glPushMatrix();
		glRotatef(AR, 0, 0, 1);
		//arm2(GL_LINE_LOOP);
		arm2(GL_POLYGON);
		glPopMatrix();
		glPopMatrix();
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