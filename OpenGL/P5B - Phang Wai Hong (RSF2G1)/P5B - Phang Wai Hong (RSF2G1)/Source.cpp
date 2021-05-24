#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>
#include <iostream>
#include <string>
#include "Function.h"

using namespace N;

#pragma comment (lib, "OpenGL32.lib")
#pragma comment (lib, "GLU32.lib")

#define WINDOW_TITLE "GL Practical 5B"
#define CW 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define SIZE 15

function fh;
int qNo = 1;
float xR = 0, yR = 0, zR = 0, xT = 0, yT = 0, zT = 0;
int count = 0;
char key = NULL, view = 'o';
float rotate = 0, rotate2 = 0, translate = 0.2, boxSize = 1, boxSize2 = 1;
float rBridge = 0, carT = 0, carSpeed = 0.02;
float C[SIZE], zoom = 0.4;
boolean isOrtho = false , bridgeLift = false, isBridgeLift = false, carAppear = false, carMove = false;
std::string str = " ";
GLenum type = GL_LINE_LOOP, gltype = GL_POLYGON;
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
			key = 'l';
			str = "left";
			xT -= translate;
		}
		else if (wParam == VK_RIGHT) {
			key = 'r';
			str = "right";
			xT += translate;
		}
		else if (wParam == VK_UP) {
			key = 'u';
			str = "up";
			zT += translate;
		}
		else if (wParam == VK_DOWN) {
			key = 'd';
			str = "down";
			zT -= translate;
		}
		else if (wParam == 0x57) {
			// W
			xR = 1, yR = 0, zR = 0;
			str = "upRotate";
		}
		else if (wParam == 0x53) {
			// S
			xR = 1, yR = 0, zR = 0;
			str = "downRotate";
		}
		else if (wParam == 0x41) {
			// A
			xR = 0, yR = 1, zR = 0;
			str = "leftRotate";
			rotate--;
		}
		else if (wParam == 0x44) {
			// D
			xR = 0, yR = 1, zR = 0;
			str = "rightRotate";
			rotate++;
		}
		else if (wParam == 0x32) {
			glLoadIdentity();
			qNo = 2;
		}
		else if (wParam == VK_SPACE) {
			glLoadIdentity();
			count = 0;
			str = "space";
		}
		else if (wParam == 0x4D) { // m
			carMove = !carMove;
		}
		else if (wParam == 0x4E) { // n
			carAppear = !carAppear;
		}
		else if (wParam == 0x4F) { // o
			//view = 'o', isOrtho = true;
		}
		else if (wParam == 0x50) { // p
			isOrtho = !isOrtho;
		}
		else if (wParam == 0x5A) {
			// z
		}
		else if (wParam == 0x33) {
			qNo = 3;
		}
		else if (wParam == 0x34) {
			qNo = 4;
		}
		else if (wParam == VK_ADD || wParam == 0xBB) {
			zoom += 0.05;
		}
		else if (wParam == VK_SUBTRACT || wParam == 0xBD) {
			zoom -= 0.05;
		}
		else if (wParam == VK_F1) {
			bridgeLift = !bridgeLift;
		}
		else if (wParam == VK_F2) {
			carAppear = true;
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

void topCone() {
	GLUquadricObj *cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glRotatef(-90, 1, 0, 0);

	//glColor3f(0.4, 0.2, 0);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluCylinder(cyl, 0.055, 0, 0.2, 30, 30);

	// border
	glColor3f(0, 0, 0);
	gluQuadricDrawStyle(cyl, GLU_LINE);
	gluCylinder(cyl, 0.056, 0, 0.2, 20, 5);

	gluDeleteQuadric(cyl);
	glPopMatrix();
}

void pillar() {
	glPushMatrix();
	glTranslatef(0, 2.1, 0);
	topCone();
	glPopMatrix();

	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glRotatef(-90, 1, 0, 0);

	glColor3f(0.40, 0.20, 0.00);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluCylinder(cyl, 0.05, 0.055, 2.1, 30, 30);

	//// border
	//glColor3f(0, 0, 0);
	//gluQuadricDrawStyle(cyl, GLU_LINE);
	//gluCylinder(cyl, 0.051, 0.055, 0.6, 20, 10);

	gluDeleteQuadric(cyl);
	glPopMatrix();
}

void centrePillar() {
	glPushMatrix();

	glPushMatrix();
	fh.color('y');
	glTranslatef(0, 0.6, 0);
	glRotatef(-90, 1, 0, 0);
	fh.cylinder(GLU_FILL, 0.15, 0, 0.3, 30, 30);
	fh.color('o');
	fh.cylinder(GLU_LINE, 0.151, 0, 0.3, 20, 5);
	glPopMatrix();

	glPushMatrix();
	glRotatef(-90, 1, 0, 0);
	glColor3f(0.63, 0.52, 0.37);
	fh.cylinder(GLU_FILL, 0.15, 0.15, 0.6, 30, 30);
	glPopMatrix();
	glPopMatrix();
}

void cube() {
	glPushMatrix();
	glTranslatef(-0.25, -0.25, -0.25);
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();
}

void cuboid() {
	glPushMatrix();
	glScalef(1.1, 0.15, 1.1);
	glTranslatef(-0.25, 1.5, -0.25);
	fh.cube(gltype, 0.5, 1);
	glPopMatrix();
}

void door() {
	
	glBegin(gltype);
	fh.circle(400, 400, 70, 100, 0, 181);
	glEnd();
}

void window() {
	glPushMatrix();
	glScalef(0.3, 0.3, 0.3);
	fh.color('c');
	glBegin(gltype);
	fh.v3f(300, 100, 0);
	fh.v3f(300, 400, 0);
	fh.v3f(500, 400, 0);
	fh.v3f(500, 100, 0);
	glEnd();
	fh.color('0');
	glLineWidth(4);
	glBegin(type);
	fh.v3f(300, 100, 0);
	fh.v3f(300, 400, 0);
	fh.v3f(500, 400, 0);
	fh.v3f(500, 100, 0);
	glEnd();
	glPopMatrix();
}

void top() {
	glPushMatrix();
	glRotatef(90, 0, 1, 0);

	glPushMatrix();
	// top cube
	glColor3f(1, 1, 1);
	cube();
	glColor3f(0.13, 0.06, 0.00);
	cuboid();

	glPushMatrix();
	glTranslatef(0, -0.25, -0.251);
	window();
	glPopMatrix();

	glPushMatrix();
	glRotatef(-90, 0, 1, 0);
	glTranslatef(0, -0.25, -0.251);
	window();
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0, -0.25, -0.251);
	window();
	glPopMatrix();

	glPushMatrix();
	glRotatef(90, 0, 1, 0);
	glTranslatef(0, -0.25, -0.251);
	window();
	glPopMatrix();

	glPopMatrix();

	// pillar 1
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(-0.25, -0.25, -0.25);
	glColor3f(1, 0, 1);
	pillar();
	glPopMatrix();

	// pillar 2
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(-0.25, -0.25, 0.25);
	glColor3f(1, 1, 0);
	pillar();
	glPopMatrix();

	// pillar 3
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(0.25, -0.25, 0.25);
	glColor3f(0, 0, 1);
	pillar();
	glPopMatrix();

	// pillar 4
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(0.25, -0.25, -0.25);
	glColor3f(0, 1, 1);
	pillar();
	glPopMatrix();

	// centre pillar
	glPushMatrix();
	centrePillar();
	glPopMatrix();

	// middle cube
	glPushMatrix();
	glTranslatef(0, -0.5, 0);
	glColor3f(1, 1, 1);
	cube();
	glColor3f(0.13, 0.06, 0.00);
	cuboid();
	glPopMatrix();

	// btm cube
	glPushMatrix();
	glTranslatef(0, -1, 0);
	glColor3f(1, 1, 1);
	cube();
	glColor3f(0.13, 0.06, 0.00);
	cuboid();

	glPushMatrix();
	glTranslatef(0, -0.250, -0.251);
	glColor3f(0, 0, 0);
	door();
	glPopMatrix();

	glTranslatef(0, -0.250, 0.251);
	glColor3f(0, 0, 0);
	door();
	glPopMatrix();

	// btm cube
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glColor3f(1, 1, 1);
	cube();
	glColor3f(0.13, 0.06, 0.00);
	cuboid();
	glPopMatrix();

	glPopMatrix();
}

void tower() {
	glPushMatrix();
	glTranslatef(-1, 0, 0);
	top();
	glPopMatrix();

	glPushMatrix();
	glTranslatef(1, 0, 0);
	top();
	glPopMatrix();
}

void crossSymbol(int dir) {
	glPushMatrix();
	glRotatef(45 * dir, 0, 0, 1);
	glScalef(0.5, 0.05, 0.5);
	glTranslatef(-0.25, -0.1, -0.25);
	fh.cube(gltype, 0.5, 1);
	glPopMatrix();
}

void crossSymbol2(float loop) {
	glPushMatrix();
	glTranslatef(-0.7 + loop, 0, 0);
	glScalef(0.5, 0.5, 0.5);
	crossSymbol(1);
	crossSymbol(-1);
	glPopMatrix();
}

void topBridge() {
	glPushMatrix();

	glPushMatrix();
	glTranslatef(0, 0, -0.2);
	glRotatef(90, 0, 1, 0);
	glScalef(0.2, 0.2, 3.0);
	glTranslatef(-0.25, -0.25, -0.25);
	fh.cube(type, 0.5, 5);
	glPopMatrix();
	glTranslatef(0, 0, 0.2);
	for (float i = 0; i <= 1.5; i += 0.1) {
		crossSymbol2(i);
	}
	glPopMatrix();

	glPushMatrix();

	glPushMatrix();
	glTranslatef(0, 0, 0.2);
	glRotatef(90, 0, 1, 0);
	glScalef(0.2, 0.2, 3.0);
	glTranslatef(-0.25, -0.25, -0.25);
	fh.cube(type, 0.5, 5);
	glPopMatrix();
	glTranslatef(0, 0, -0.2);
	for (float i = 0; i <= 1.5; i += 0.1) {
		crossSymbol2(i);
	}
	glPopMatrix();
}

void road() {
	glPushMatrix();
	glScalef(1.5, 0.25, 1);
	glTranslatef(-0.25, 0, 0);
	glTranslatef(-0.25, -0.25, -0.25);
	glColor3f(0.3, 0.3, 0.3);
	fh.cube(gltype, 0.5, 3);
	glPopMatrix();
}

void downBridge() {
	glPushMatrix();
	glTranslatef(0.75, 0, 0);
	glTranslatef(0, -1.3, 0);
	glRotatef(-rBridge, 0, 0, 1);
	road();
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0.75, 0, 0);
	glTranslatef(0, -1.3, 0);
	glRotatef(-rBridge, 0, 0, 1);
	road();
	glPopMatrix();
}

void topWire() {
	glPushMatrix();
	glTranslatef(0.75, 0, 0);
	glRotatef(-15, 0, 0, 1);
	glRotatef(90, 0, 1, 0);
	glColor3f(0.00, 0.59, 0.89);
	fh.cylinder(GLU_FILL, 0.02, 0.02, 2.75, 30, 30);
	glPopMatrix();	
}

void verWire(float length) {
	glLineWidth(3);
	glColor3f(0, 0, 0);
	glBegin(GL_LINES);
	glVertex3f(0, length, 0);
	glVertex3f(0, 0, 0);
	glEnd();
}

void roadWireRight() {
	// right front
	glPushMatrix();
	glTranslatef(0, 0, 0.2);
	topWire();
	glPopMatrix();

	// right back
	glPushMatrix();
	glTranslatef(0, 0, -0.2);
	topWire();
	glPopMatrix();

	// left front
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0, 0, 0.2);
	topWire();
	glPopMatrix();

	// left back
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0, 0, -0.2);
	topWire();
	glPopMatrix();

	// back
	glPushMatrix();
	glTranslatef(1.5, -1.25, -0.2);
	verWire(1.05);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(1.7, -1.25, -0.2);
	verWire(1);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(1.9, -1.25, -0.2);
	verWire(0.95);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.1, -1.25, -0.2);
	verWire(0.9);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.3, -1.25, -0.2);
	verWire(0.85);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.5, -1.25, -0.2);
	verWire(0.79);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.7, -1.25, -0.2);
	verWire(0.74);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.9, -1.25, -0.2);
	verWire(0.69);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(3.1, -1.25, -0.2);
	verWire(0.64);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(3.3, -1.25, -0.2);
	verWire(0.59);
	glPopMatrix();

	// front
	glPushMatrix();
	glTranslatef(1.5, -1.25, 0.2);
	verWire(1.05);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(1.7, -1.25, 0.2);
	verWire(1);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(1.9, -1.25, 0.2);
	verWire(0.95);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.1, -1.25, 0.2);
	verWire(0.9);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.3, -1.25, 0.2);
	verWire(0.85);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.5, -1.25, 0.2);
	verWire(0.79);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.7, -1.25, 0.2);
	verWire(0.74);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(2.9, -1.25, 0.2);
	verWire(0.69);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(3.1, -1.25, 0.2);
	verWire(0.64);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(3.3, -1.25, 0.2);
	verWire(0.59);
	glPopMatrix();
}

void roadWireLeft() {
	// left front
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0, 0, 0.2);
	topWire();
	glPopMatrix();

	// left back
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(0, 0, -0.2);
	topWire();
	glPopMatrix();

	// back
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.5, -1.25, -0.2);
	verWire(1.05);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.7, -1.25, -0.2);
	verWire(1);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.9, -1.25, -0.2);
	verWire(0.95);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.1, -1.25, -0.2);
	verWire(0.9);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.3, -1.25, -0.2);
	verWire(0.85);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.5, -1.25, -0.2);
	verWire(0.79);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.7, -1.25, -0.2);
	verWire(0.74);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.9, -1.25, -0.2);
	verWire(0.69);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(3.1, -1.25, -0.2);
	verWire(0.64);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(3.3, -1.25, -0.2);
	verWire(0.59);
	glPopMatrix();

	// front
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.5, -1.25, 0.2);
	verWire(1.05);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.7, -1.25, 0.2);
	verWire(1);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(1.9, -1.25, 0.2);
	verWire(0.95);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.1, -1.25, 0.2);
	verWire(0.9);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.3, -1.25, 0.2);
	verWire(0.85);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.5, -1.25, 0.2);
	verWire(0.79);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.7, -1.25, 0.2);
	verWire(0.74);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.9, -1.25, 0.2);
	verWire(0.69);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(3.1, -1.25, 0.2);
	verWire(0.64);
	glPopMatrix();

	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(3.3, -1.25, 0.2);
	verWire(0.59);
	glPopMatrix();
}

void roadPillar(float pos) {
	glPushMatrix();
	glTranslatef(pos, -1.27, 0);
	glRotatef(90, 1, 0, 0);
	glColor3f(0.98, 0.71, 0.15);
	fh.cylinder(GLU_FILL, 0.2, 0.2, 0.5, 30, 30);
	glPopMatrix();

	// border
	glPushMatrix();
	glTranslatef(pos, -1.27, 0);
	glRotatef(90, 1, 0, 0);
	fh.color('o');
	fh.cylinder(GLU_LINE, 0.2, 0.2, 0.5, 30, 10);
	glPopMatrix();
}

void outsideRoad() {
	// left 1
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.0, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	// left 2
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(2.75, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	// left 3
	glPushMatrix();
	glRotatef(180, 0, 1, 0);
	glTranslatef(3.5, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	// right 1
	glPushMatrix();
	glTranslatef(2.0, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	// right 2
	glPushMatrix();
	glTranslatef(2.75, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	// right 3
	glPushMatrix();
	glTranslatef(3.5, 0, 0);
	glTranslatef(0, -1.3, 0);
	road();
	glPopMatrix();

	roadWireRight();
	roadWireLeft();

	float spacing = 0;
	for (int i = 0; i < 3; i++) {
		roadPillar(1.7 + spacing);
		roadPillar(-1.7 - spacing);
		spacing += 0.8;
	}
}

void car(float position, int dir) {
	glPushMatrix();
	glScalef(0.5, 0.5, 0.3);
	glTranslatef((carT + position) * dir, -2.33, -0.25 * dir);

	// body
	glPushMatrix();
	fh.color('y');
	glScalef(1, 0.25, 0.5);
	glTranslatef(-0.25, -0.25, -0.25);
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();

	// body top
	glPushMatrix();
	fh.color('b');
	glScalef(0.5, 0.25, 0.4);
	glTranslatef(-0.25, 0.2, -0.25);
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();

	// window 1
	glPushMatrix();
	fh.color('c');
	glScalef(0.4, 0.2, 0.405);
	glTranslatef(-0.25, 0.2, -0.25);
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();

	// window 2
	glPushMatrix();
	fh.color('c');
	glScalef(0.51, 0.2, 0.3);
	glTranslatef(-0.25, 0.2, -0.25);
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();

	// tire 1
	glPushMatrix();
	fh.color('o');
	glTranslatef(-0.2, -0.1, -0.1);
	fh.sphere(GLU_FILL, 0.05, 30, 30);
	glPopMatrix();

	// tire 2
	glPushMatrix();
	fh.color('o');
	glTranslatef(-0.2, -0.1, 0.1);
	fh.sphere(GLU_FILL, 0.05, 30, 30);
	glPopMatrix();

	// tire 3
	glPushMatrix();
	fh.color('o');
	glTranslatef(0.2, -0.1, 0.1);
	fh.sphere(GLU_FILL, 0.05, 30, 30);
	glPopMatrix();

	// tire 4
	glPushMatrix();
	fh.color('o');
	glTranslatef(0.2, -0.1, -0.1);
	fh.sphere(GLU_FILL, 0.05, 30, 30);
	glPopMatrix();

	glPopMatrix();
}

void londonBridge() {
	tower();
	topBridge();
	downBridge();
	outsideRoad();
	if (carAppear) {
		car(-6, -1);
		car(-6, 1);
	}
	
}

void sea() {
	glPushMatrix();
	glColor3f(0.00, 0.59, 0.89);
	glTranslatef(0, -2, 0);
	glScalef(7, 0.5, 1);
	glTranslatef(-0.5, -0.5, -0.5);
	fh.cube(gltype, 1, 1);
	glPopMatrix();
}

void bottle() {
	glDisable(GL_DEPTH_TEST);
	glPushMatrix();
	glTranslatef(-3.5, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('w');
	fh.cylinder(GLU_FILL, 1.7, 1.7, 7, 50, 50);
	glPopMatrix();	

	glPushMatrix();
	glTranslatef(-3.5, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('w');
	fh.disk(GLU_FILL, 0, 1.7, 50, 1);
	glPopMatrix();
	glEnable(GL_DEPTH_TEST);

	glPushMatrix();
	glTranslatef(-3.501, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('o');
	fh.disk(GLU_LINE, 1.7, 1.7, 50, 1);
	glPopMatrix();

	glPushMatrix();
	glTranslatef(-3.501, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('o');
	fh.disk(GLU_LINE, 1, 1, 50, 1);
	glPopMatrix();

	glDisable(GL_DEPTH_TEST);
	glPushMatrix();
	glTranslatef(3.5, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('w');
	fh.cylinder(GLU_FILL, 1.7, 0.7, 2, 50, 50);
	glPopMatrix();
	glEnable(GL_DEPTH_TEST);

	glPushMatrix();
	glTranslatef(5.501, -0.75, 0);
	glRotatef(90, 0, 1, 0);
	fh.color('o');
	fh.disk(GLU_LINE, 0.7, 0.7, 50, 1);
	glPopMatrix();

	// closer
	glPushMatrix();
	glTranslatef(5.5, -0.75, 0);
	glColor3f(0.44, 0.29, 0.00);
	fh.sphere(GLU_FILL, 0.7, 50, 50);
	glPopMatrix();
}

void animation() {
	if (bridgeLift && rBridge < 45) {
		rBridge++;
	}
	else if (!bridgeLift && rBridge > 0) {
		rBridge--;
	}

	if (rBridge == 45) {
		isBridgeLift = true;
	}
	else {
		isBridgeLift = false;
	}

	if (carAppear && carMove) {
		carT += carSpeed;
	}
	if (carT > 12) {
		carAppear = false;
		carT = 0;
	}

	if (bridgeLift && carT < 8) {
		carAppear = false;
	}
	else if(rBridge == 0) {
		carAppear = true;
	}

	// press 'a'/'w'/'d'/'s' to rotate 
	if (str == "leftRotate" || str == "upRotate") {
		rotate++;
	}
	else if (str == "rightRotate" || str == "downRotate") {
		rotate--;
	}
	else if (str == "space") {
		glLoadIdentity();
	}
}

void projection() {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	if (isOrtho) {
		glOrtho(-boxSize, boxSize, -boxSize, boxSize, -boxSize, boxSize);
	}
	else{
		gluPerspective(60, 1, 1, -1);
		glFrustum(-boxSize2, boxSize2, -boxSize2, boxSize2, 1, boxSize2 * 2 + 1);
	}
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

void display()
{
	glClearColor(0.65, 0.89, 0.93, 0);
	glEnable(GL_DEPTH_TEST);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	
	projection();
	animation();

	switch (qNo) {
	case 1:
		glPushMatrix();
		glTranslatef(xT, yT, zT);
		glRotatef(rotate, xR, yR, zR);
		glScalef(zoom, zoom, zoom);
		bottle();
		londonBridge();
		sea();
		glPopMatrix();
		break;
	case 2:
		glPushMatrix();
		glTranslatef(xT, yT, zT);
		glRotatef(rotate, xR, yR, zR);
		glScalef(zoom, zoom, zoom);
		//roadPillar();
		glPopMatrix();
		break;
	case 3:
		break;
	case 4:
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