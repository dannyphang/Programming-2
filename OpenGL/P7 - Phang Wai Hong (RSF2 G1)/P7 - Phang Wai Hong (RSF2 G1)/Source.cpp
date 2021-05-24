#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>
#include <string>
#include "Function.h"

#pragma comment (lib, "OpenGL32.lib")
#pragma comment (lib, "GLU32.lib")

using namespace N;

//constants & global variables
#define WINDOW_TITLE "Practical Exercise 7"
#define CW 10
#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define BORDER 8
#define PI 3.141592654
#define ORTHO_VIEW 1.0
#define FRUSTUM_VIEW 1.0
#define noOfSegment 30

function fh;

GLuint texture = 3;	// texture name
BITMAP BMP;			// bitmap structure
HBITMAP hBMP= NULL;	// bitmap handle

int qNo = 1;
float zoom = 1.0;
float rotate = 0, translate = 0.2, xT = 0, yT = 0, xR = 1, yR = 0, zR = 0;
float rSpeed = 1, tSpeed = 0.1;
std::string str = " ";
LPCSTR textureImg = "Box.bmp";
char key = NULL, view = 'o';
float rotate2 = 0, boxSize = 1, boxSize2 = 1;
float rBridge = 0, carT = 0, carSpeed = 0.02;
boolean isOrtho = false, bridgeLift = false, isBridgeLift = false, carAppear = false, carMove = false;
GLenum type = GL_LINE_LOOP, gltype = GL_POLYGON;

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
			qNo = 1;
		}
		else if (wParam == 0x32) {
			qNo = 2;
		}
		else if (wParam == 0x33) {
			qNo = 3;
		}
		else if (wParam == 0x34) {
			qNo = 4;
		}
		else if (wParam == VK_F1) {
			textureImg = "Box.bmp";
		}
		else if (wParam == VK_F2) {
			textureImg = "brick.bmp";
		}
		else if (wParam == VK_F3) {
			textureImg = "metal.bmp";
		} 
		else if (wParam == VK_F4) {
			textureImg = "redMetal.bmp";
		}
		else if (wParam == VK_F5) {
			textureImg = "universe.bmp";
		}
		else if (wParam == VK_F6) {

		}
		else if (wParam == VK_LEFT) {
			xT -= tSpeed;
		}
		else if (wParam == VK_RIGHT) {
			xT += tSpeed;
		}
		else if (wParam == VK_UP) {
			yT += tSpeed;
		}
		else if (wParam == VK_DOWN) {
			yT -= tSpeed;
		}
		else if (wParam == 0x32) {
			qNo = 2;
		}
		else if (wParam == VK_SPACE) {
			str = "space";
		}
		else if (wParam == 0x57) {	// W
			xR = 1, yR = 0, zR = 0;
			str = "upRotate";
		}
		else if (wParam == 0x53) {	// S
			xR = 1, yR = 0, zR = 0;
			str = "downRotate";
		}
		else if (wParam == 0x41) {	// A
			xR = 0, yR = 1, zR = 0;
			str = "leftRotate";
		}
		else if (wParam == 0x44) {	// D
			xR = 0, yR = 1, zR = 0;
			str = "rightRotate";
		}
		else if (wParam == 0x52) {	// R
			xR = 1, yR = 1, zR = 1;
			str = "rightRotate";
		}
		else if (wParam == 0x4D) { // m
			carMove = !carMove;
		}
		else if (wParam == 0x4E) { // n
			carAppear = !carAppear;
		}
		else if (wParam == 0x4F) { // o
			
		}
		else if (wParam == 0x50) { // p
			isOrtho = !isOrtho;
		}
		else if (wParam == VK_ADD || wParam == 0xBB) {
			zoom += 0.1;
		}
		else if (wParam == VK_SUBTRACT || wParam == 0xBD) {
			zoom -= 0.1;
		}
		else if (wParam == 0x4C) { // L
			bridgeLift = !bridgeLift;
		}
		else if (wParam == 0x4B) { // K
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

void projection() {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	if (isOrtho) {
		glOrtho(-boxSize, boxSize, -boxSize, boxSize, -boxSize, boxSize);
	}
	else {
		gluPerspective(60, 1, 1, -1);
		glFrustum(-boxSize2, boxSize2, -boxSize2, boxSize2, 1, boxSize2 * 2 + 1);
	}
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

GLuint addTexture(LPCSTR textureName) {
	glPixelStorei(GL_UNPACK_ALIGNMENT, 4);

	HBITMAP hBMP = (HBITMAP)LoadImage(GetModuleHandle(NULL),
		textureName, IMAGE_BITMAP, 0, 0,
		LR_CREATEDIBSECTION | LR_LOADFROMFILE);

	GetObject(hBMP, sizeof(BMP), &BMP);

	// Assign texture to polygon
	glEnable(GL_TEXTURE_2D);

	glGenTextures(1, &texture);
	glBindTexture(GL_TEXTURE_2D, texture);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, BMP.bmWidth, BMP.bmHeight, 0,
		GL_BGR_EXT, GL_UNSIGNED_BYTE, BMP.bmBits);
	DeleteObject(hBMP);
	return texture;
}

void removeTexture() {
	glDisable(GL_TEXTURE_2D);

	glDeleteTextures(1, &texture);
}

void topCone() {
	GLuint textures2[1];
	textures2[0] = addTexture("yellowBrick.bmp");
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glRotatef(-90, 1, 0, 0);

	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluQuadricTexture(cyl, true);
	gluCylinder(cyl, 0.055, 0, 0.2, 30, 30);

	gluDeleteQuadric(cyl);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void pillar() {
	GLuint textures2[2];
	
	glPushMatrix();
	glTranslatef(0, 2.1, 0);
	topCone();
	glPopMatrix();
	

	textures2[0] = addTexture("whiteBrick.bmp");
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glRotatef(-90, 1, 0, 0);

	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluQuadricTexture(cyl, true);
	gluCylinder(cyl, 0.05, 0.055, 2.1, 30, 30);

	gluDeleteQuadric(cyl);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void centrePillar() {
	glPushMatrix();
	GLuint textures2[2];
	textures2[0] = addTexture("goldBrick.bmp");
	glPushMatrix();
	fh.color('w');
	glTranslatef(0, 0.6, 0);
	glRotatef(-90, 1, 0, 0);
	fh.cylinder(GLU_FILL, 0.15, 0, 0.3, 30, 30);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);

	textures2[1] = addTexture("greyBrick.bmp");
	glPushMatrix();
	glRotatef(-90, 1, 0, 0);
	fh.cylinder(GLU_FILL, 0.15, 0.15, 0.6, 30, 30);
	glPopMatrix();
	glDeleteTextures(1, &textures2[1]);
	glPopMatrix();
}

void cube() {
	GLuint textures2[1];
	textures2[0] = addTexture("whiteBrick.bmp");
	glPushMatrix();
	glTranslatef(-0.25, -0.25, -0.25);
	fh.color('w');
	fh.cube(gltype, 0.5, 2);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void cuboid() {
	GLuint textures2[1];
	textures2[0] = addTexture("blackBrick.bmp");
	glPushMatrix();
	glScalef(1.1, 0.15, 1.1);
	glTranslatef(-0.25, 1.5, -0.25);
	fh.cube(gltype, 0.5, 1);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void door() {

	glBegin(gltype);
	fh.circle(400, 400, 70, 100, 0, 181);
	glEnd();
}

void window() {
	GLuint textures2[1];
	textures2[0] = addTexture("window.bmp");
	glPushMatrix();
	glScalef(0.3, 0.3, 0.3);
	fh.color('w');
	glBegin(gltype);
	glTexCoord2f(0.0, 1.0), fh.v3f(300, 100, 0);
	glTexCoord2f(1.0, 1.0), fh.v3f(300, 400, 0);
	glTexCoord2f(1.0, 0.0), fh.v3f(500, 400, 0);
	glTexCoord2f(0.0, 0.0), fh.v3f(500, 100, 0);
	glEnd();
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void top() {
	glPushMatrix();
	glRotatef(90, 0, 1, 0);

	glPushMatrix();
	// top cube
	glColor3f(1, 1, 1);
	cube();
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
	//glColor3f(1, 0, 1);
	pillar();
	glPopMatrix();

	// pillar 2
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(-0.25, -0.25, 0.25);
	//glColor3f(1, 1, 0);
	pillar();
	glPopMatrix();

	// pillar 3
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(0.25, -0.25, 0.25);
	//glColor3f(0, 0, 1);
	pillar();
	glPopMatrix();

	// pillar 4
	glPushMatrix();
	glTranslatef(0, -1.5, 0);
	glTranslatef(0.25, -0.25, -0.25);
	//glColor3f(0, 1, 1);
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
	cuboid();
	glPopMatrix();

	// btm cube
	glPushMatrix();
	glTranslatef(0, -1, 0);
	glColor3f(1, 1, 1);
	cube();
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
	GLuint textures2[1];
	textures2[0] = addTexture("blackMetal.bmp");
	glPushMatrix();
	glTranslatef(-0.7 + loop, 0, 0);
	glScalef(0.5, 0.5, 0.5);
	crossSymbol(1);
	crossSymbol(-1);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void topBridge() {
	GLuint textures2[2];
	textures2[0] = addTexture("greyMetal.bmp");
	glPushMatrix();
	
	glPushMatrix();
	glTranslatef(0, 0, -0.2);
	glRotatef(90, 0, 1, 0);
	glScalef(0.2, 0.2, 3.0);
	glTranslatef(-0.25, -0.25, -0.25);
	fh.cube(type, 0.5, 5);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);

	glTranslatef(0, 0, 0.2);
	for (float i = 0; i <= 1.5; i += 0.1) {
		crossSymbol2(i);
	}
	glPopMatrix();

	textures2[1] = addTexture("greyMetal.bmp");
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
	glDeleteTextures(1, &textures2[1]);
}

void road() {
	GLuint textures2[1];
	textures2[0] = addTexture("road.bmp");
	glPushMatrix();
	glScalef(1.5, 0.25, 1);
	glTranslatef(-0.25, 0, 0);
	glTranslatef(-0.25, -0.25, -0.25);
	fh.color('w');
	fh.cube(gltype, 0.5, 3);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
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
	GLuint textures2[1];
	textures2[0] = addTexture("redWire.bmp");
	glPushMatrix();
	glTranslatef(0.75, 0, 0);
	glRotatef(-15, 0, 0, 1);
	glRotatef(90, 0, 1, 0);
	fh.cylinder(GLU_FILL, 0.02, 0.02, 2.75, 30, 30);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void verWire(float length) {
	GLuint textures2[1];
	textures2[0] = addTexture("road.bmp");
	glLineWidth(3);
	glColor3f(1, 1, 1);
	glBegin(GL_LINES);
	glTexCoord2f(0.0, 1.0), glVertex3f(0, length, 0);
	glTexCoord2f(1.0, 1.0), glVertex3f(0, 0, 0);
	glEnd();
	glDeleteTextures(1, &textures2[0]);
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
	GLuint textures2[1];
	textures2[0] = addTexture("brick.bmp");
	glPushMatrix();
	glTranslatef(pos, -1.27, 0);
	glRotatef(90, 1, 0, 0);
	glColor3f(0.98, 0.71, 0.15);
	fh.cylinder(GLU_FILL, 0.2, 0.2, 0.5, 30, 30);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
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
	GLuint textures2[1];
	textures2[0] = addTexture("sea.bmp");
	glPushMatrix();
	glTranslatef(0, -2, 0);
	glScalef(7, 0.5, 1);
	glTranslatef(-0.5, -0.5, -0.5);
	fh.color('w');
	fh.cube(gltype, 1, 1);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);

}

void cone() {
	GLuint textures2[1];
	textures2[0] = addTexture("iceCreamCone.bmp");
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluQuadricTexture(cyl, true);
	gluCylinder(cyl, 0.0, 0.2, 0.5, 20, 10);

	gluDeleteQuadric(cyl);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void ball() {
	GLuint textures2[1];
	textures2[0] = addTexture("iceCream.bmp");
	GLUquadricObj* ball1 = NULL;
	ball1 = gluNewQuadric();

	glPushMatrix();
	glTranslatef(0, 0.3, 0);
	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(ball1, GLU_FILL);
	gluQuadricTexture(ball1, true);
	gluSphere(ball1, 0.185, 30, 30);
	gluDeleteQuadric(ball1);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void ball2() {
	GLuint textures2[1];
	textures2[0] = addTexture("iceCream2.bmp");
	GLUquadricObj* ball1 = NULL;
	ball1 = gluNewQuadric();
	glPushMatrix();
	glTranslatef(0, 0.55, 0);
	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(ball1, GLU_FILL);
	gluQuadricTexture(ball1, true);
	gluSphere(ball1, 0.185, 30, 30);

	gluDeleteQuadric(ball1);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void cherry() {
	GLUquadricObj* cherry = NULL;
	cherry = gluNewQuadric();
	glPushMatrix();
	glTranslatef(0.14, 0.67, 0);
	glColor3f(1, 0, 0);
	gluQuadricDrawStyle(cherry, GLU_FILL);
	gluQuadricDrawStyle(cherry, type);
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
	GLuint textures2[1];
	textures2[0] = addTexture("chocolate.bmp");
	GLUquadricObj* cyl = NULL;
	cyl = gluNewQuadric();

	glPushMatrix();
	glTranslatef(0, 0.6, 0);
	glRotatef(-25, 0, 0, 1);
	glTranslatef(0, -0.25, 0);
	glRotatef(-90, 1, 0, 0);
	glColor3f(1, 1, 1);
	gluQuadricDrawStyle(cyl, GLU_FILL);
	gluQuadricTexture(cyl, true);
	gluCylinder(cyl, 0.03, 0.03, 0.5, 30, 10);
	gluDeleteQuadric(cyl);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
}

void question1() {
	addTexture(textureImg);
	glPushMatrix();
	fh.color('w');
	fh.pyramid(GL_POLYGON, 0.5, 3);
	glPopMatrix();
	removeTexture();
}

void question2() {
	addTexture(textureImg);
	glPushMatrix();
	glTranslatef(-0.5, -0.5, -0.5);
	//color('w');
	fh.cube(GL_POLYGON, 1.0, 3);
	glPopMatrix();
	removeTexture();
}

void question3() {
	glPushMatrix();
	glRotatef(-10, 1, 0, 0);
	glRotatef(rotate2, 0, 1, 0);

	biskut();
	cherry();
	ball();
	ball2();

	glTranslatef(0, -0.25, 0);
	glRotatef(-90, 1, 0, 0);
	cone();
	glPopMatrix();
}

void question4() {
	glPushMatrix();
	GLuint textures2[1];
	textures2[0] = addTexture("sky.bmp");
	glPushMatrix();
	glEnable(GL_TEXTURE_2D);
	glPushMatrix();
	glRotatef(-90, 1, 0, 0);
	fh.color('w');
	fh.sphere(GLU_FILL, FRUSTUM_VIEW * 10, 50, 50);
	glPopMatrix();
	glDeleteTextures(1, &textures2[0]);
	glPopMatrix();

	londonBridge();
	sea();
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
	else if (rBridge == 0) {
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

void display()
{
	init();
	animation();
	rotate2++;
	
	projection();
	
	switch (qNo) {
	case 1:
		glPushMatrix();
		glRotatef(rotate, xR, yR, zR);
		glTranslatef(xT, yT, 0);
		question1();
		glPopMatrix();
		break;
	case 2:
		glPushMatrix();
		glScalef(zoom, zoom, zoom);
		glRotatef(rotate, xR, yR, zR);
		glTranslatef(xT, yT, 0);
		question2();
		glPopMatrix();
		break;
	case 3:
		glPushMatrix();
		glScalef(zoom, zoom, zoom);
		glRotatef(rotate, xR, yR, zR);
		glTranslatef(xT, yT, 0);
		question3();
		glPopMatrix();
		break;
	case 4:
		glPushMatrix();
		glScalef(zoom, zoom, zoom);
		glRotatef(rotate, xR, yR, zR);
		glTranslatef(xT, yT, 0);
		question4();
		glPopMatrix();
		break;
	default:
		break;
	}

	removeTexture();
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