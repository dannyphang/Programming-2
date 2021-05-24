#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>

#pragma comment (lib, "OpenGL32.lib")
#pragma comment (lib, "GLU32.lib")

#define WINDOW_TITLE "Practical 6"
#define CW_USEDEFAULT 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define BORDER 8
#define PI 3.141592654
#define ORTHO_VIEW 1.0
#define FRUSTUM_VIEW 1.0

int qNo = 1, noOfSegment = 30;
float rx = 1.0, ry = 1.0, rz = 1.0, rSpeedP = 10.0, rDirection = 0;
float tSpeed = 0.1, tSpeedP = 0.1, tx = 0, ty = 0, tz = 0, angle = 0, r = 0;
char lightDir = 'o'; // origin

float diff[] = { 1.0, 0.0, 0.0 }; //diffuse light
float posD[] = { tx, ty, tz };
float diffM[] = { 1.0, 0.0, 1.0 };

boolean lightOn = true;
boolean isSphere = true;
float lightRPos = 0.1;

LRESULT WINAPI WindowProcedure(HWND hWnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
	switch (msg)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		break;

	case WM_KEYDOWN:
		if (wParam == VK_ESCAPE)
			PostQuitMessage(0);
		else if (wParam == VK_UP)
			rDirection = -0.5;
		else if (wParam == VK_DOWN)
			rDirection = 0.5;
		else if (wParam == 0x4F) //o - sphere
			isSphere = true;
		else if (wParam == 0x50) //p - pyramid
			isSphere = false;
		else if (wParam == 0x41) //a - left
			tx -= lightRPos, ty += 0.0, tz += 0.0;
		else if (wParam == 0x44) //d - right
			tx += lightRPos, ty += 0.0, tz += 0.0;
		else if (wParam == 0x53) //s - down
			tx += 0.0, ty -= lightRPos, tz += 0.0;
		else if (wParam == 0x57) //w - up
			tx += 0.0, ty += lightRPos, tz += 0.0;
		else if (wParam == 0x45) //e - near
			tx += 0.0, ty += 0.0, tz -= lightRPos;
		else if (wParam == 0x51) //q - far
			tx += 0.0, ty += 0.0, tz += lightRPos;
		else if (wParam == VK_SPACE)
			lightOn = !lightOn, lightDir = 'o';
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

void init() {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glEnable(GL_DEPTH_TEST);
}

void color(char smallLetterColorChar) {
	float on = 1.0, off = 0;
	float red = off, green = off, blue = off;

	switch (smallLetterColorChar) {
	case 'r': red = on; break;
	case 'g': green = on; break;
	case 'b': blue = on; break;
	case 'w': red = on, green = on, blue = on; break;
	case 'y': red = on, green = on, blue = off; break; //yellow
	case 'c': red = off, green = on, blue = on; break; //cyan
	case 'o': red = off, green = off, blue = off; //others - stands for black
	}
	glColor3f(red, green, blue);
}

void pyramid(GLenum type, float size, int lineWidth) {
	glBegin(type);
	//front
	glNormal3f(0, size, size);
	glVertex3f(0, size, 0);
	glVertex3f(-size, -size, size);
	glVertex3f(size, -size, size);

	//right
	glNormal3f(size, 0, 0);
	glVertex3f(0, size, 0);
	glVertex3f(size, -size, size);
	glVertex3f(size, -size, -size);

	//back
	glNormal3f(0, 0, -size);
	glVertex3f(0, size, 0);
	glVertex3f(size, -size, -size);
	glVertex3f(-size, -size, -size);

	//left
	glNormal3f(-size, 0, 0);
	glVertex3f(0, size, 0);
	glVertex3f(-size, -size, -size);
	glVertex3f(-size, -size, size);
	glEnd();

	glBegin(type);
	glNormal3f(0, -size, 0);
	glVertex3f(-size, -size, size);
	glVertex3f(size, -size, size);
	glVertex3f(size, -size, size);
	glVertex3f(size, -size, -size);
	glVertex3f(size, -size, -size);
	glVertex3f(-size, -size, -size);
	glVertex3f(-size, -size, -size);
	glVertex3f(-size, -size, size);
	glEnd();
}

void sphere(GLenum type, float radius, int slice, int stack) {
	GLUquadricObj* sphere = NULL;
	sphere = gluNewQuadric();
	gluQuadricDrawStyle(sphere, type);
	gluSphere(sphere, radius, slice, stack);
}

void lighting() {

	if (lightOn) {
		glEnable(GL_LIGHTING);
	}
	else
		glDisable(GL_LIGHTING);

	posD[0] = tx;
	posD[1] = ty;
	posD[2] = tz;
	glLightfv(GL_LIGHT1, GL_DIFFUSE, diff);
	glEnable(GL_LIGHT1);
	glLightfv(GL_LIGHT1, GL_POSITION, posD);

	glRotatef(rDirection, rx, ry, rz);
	//glMaterialfv(GL_FRONT, GL_AMBIENT, ambM);
	glMaterialfv(GL_FRONT, GL_DIFFUSE, diffM);
}

void display()
{
	init();

	lighting();
	color('b');
	if (isSphere)
		sphere(GLU_FILL, 0.5, 30, 30);
	else
		pyramid(GL_POLYGON, 0.5, 1);
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
		CW_USEDEFAULT, CW_USEDEFAULT, 800, 800,
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