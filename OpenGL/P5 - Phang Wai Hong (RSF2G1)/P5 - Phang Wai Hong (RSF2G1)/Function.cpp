#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>
#include <iostream>
#include "Function.h"

using namespace N;
using namespace std;

#define VALUE 800.0
#define WIDTH VALUE
#define HEIGHT VALUE
#define DEPTH VALUE
#define M_PI 3.141593

float function::xC(float x) {
	float xCoor = 0, width = WIDTH / 2;
	if (x >= 0 && x < width) {
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

float function::zC(float z) {
	float zCoor, depth = DEPTH / 2;

	zCoor = z / depth;

	return -zCoor;
}

float function::yC(float y) {
	float yCoor, height = HEIGHT / 2;
	if (y > 0 && y < height) {
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

float function::xP(float x) {
	return (x / (WIDTH / 2));
}

float function::yP(float y) {
	return (y / (HEIGHT / 2));
}

float function::zP(float z) {
	return (z / (DEPTH / 2));
}

float function::cC(float color) {
	return (color / 255);
}

void function::v3f(float x, float y, float z) {
	glVertex3f(xC(x), yC(y), zC(z));
}

void function::v2f(float x, float y) {
	glVertex2f(xC(x), yC(y));
}

void function::poly3(GLenum type, float* array, int num) {
	int noEmpty = 0, empty = 0;
	for (int i = 0; i < num; i++) {
		if (array[i] == 1000000) {
			empty++;
		}
	}

	noEmpty = num - empty;

	glBegin(type);
	for (int i = 0; i < noEmpty; i += 3) {
		glVertex3f(array[i], array[i + 1], array[i + 2]);
	}
	glEnd();

	for (int i = 0; i < noEmpty; i++) {
		array[i] = 1000000;
	}
}

void function::sphere(GLenum type, float xradius, float yradius, float zradius, int xaxis, int yaxis, float zaxis, float xmin, float xmax, float ymin, float ymax, float r, float g, float b) {
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

		glBegin(type);
		for (j = ymin; j <= ymax; j++) {
			float lng = 2 * M_PI * (j - 1.0) / longs;
			float x = cos(lng);
			float y = sin(lng);

			glColor3f(r, g, b);
			//glNormal3f(x2 + x * zr0, y2 + y * zr0, z2 + z0);
			glVertex3f(x2 + xr * x * zr0, y2 + yr * y * zr0, z2 + zr * z0);

			//glColor3f(1, 0, 0);
			//glNormal3f(x2 + x * zr1, y2 + y * zr1, z2 + z1);
			glVertex3f(x2 + xr * x * zr1, y2 + yr * y * zr1, z2 + zr * z1);
		}
		glEnd();
	}
}

void function::circle(float x, float y, float xr, float yr, float min, float max) {
	//float z2;
	for (float i = min; i < max; i++)
	{
		float x2 = xC(x) + cos(i * M_PI / 180.f) * xP(xr);
		float y2 = yC(y) + sin(i * M_PI / 180.f) * yP(yr);
		glVertex2f(x2, y2);
	}
}

void function::triangle(GLenum type, float base, float height, int lineWidth) {
	int xStartCoor = 400, yStartCoor = 400;
	glLineWidth(lineWidth);
	glBegin(type);
	v2f(xStartCoor, yStartCoor);
	v2f(xStartCoor + base, yStartCoor);
	v2f(xStartCoor + (base / 2), yStartCoor - height);
	glEnd();
}

void function::quad(GLenum type, float length, float height, int lineWidth) {
	int xStartCoor = 400, yStartCoor = 400;
	glLineWidth(lineWidth);
	glBegin(type);
	v2f(xStartCoor, yStartCoor - height);
	v2f(xStartCoor, yStartCoor);
	v2f(xStartCoor + length, yStartCoor);
	v2f(xStartCoor + length, yStartCoor - height);
	glEnd();
}

//for 3D objects, size value follows openGL coordinates, so use xC/yC/zC if you need it in pixels
void function::pyramid(GLenum type, float size, int lineWidth) {
	float x = xC(size), y = yC(size), z = zC(size);
	glBegin(type);
	//front
	glVertex3f(0, y, 0);
	glVertex3f(-x, -y, z);
	glVertex3f(x, -y, z);

	//right
	glVertex3f(0, y, 0);
	glVertex3f(x, -y, z);
	glVertex3f(x, -y, -z);

	//back
	glVertex3f(0, y, 0);
	glVertex3f(x, -y, -z);
	glVertex3f(-x, -y, -z);

	//left
	glVertex3f(0, y, 0);
	glVertex3f(-x, -y, -z);
	glVertex3f(-x, -y, z);
	glEnd();

	glBegin(type);
	glVertex3f(-x, -y, z);
	glVertex3f(x, -y, z);
	glVertex3f(x, -y, z);
	glVertex3f(x, -y, -z);
	glVertex3f(x, -y, -z);
	glVertex3f(-x, -y, -z);
	glVertex3f(-x, -y, -z);
	glVertex3f(-x, -y, z);
	glEnd();
}

void function::cube(GLenum type, float size, int lineWidth) {
	float x = xC(size), y = yC(size), z = zC(size);
	glLineWidth(lineWidth);
	//top
	glBegin(type);
	glVertex3f(0, y, z);
	glVertex3f(0, 0, z);
	glVertex3f(x, 0, z);
	glVertex3f(x, y, z);
	glEnd();
	//right
	glBegin(type);
	glVertex3f(x, y, z);
	glVertex3f(x, 0, z);
	glVertex3f(x, 0, 0);
	glVertex3f(x, y, 0);
	glEnd();
	//left
	glBegin(type);
	glVertex3f(0, y, z);
	glVertex3f(0, 0, z);
	glVertex3f(0, 0, 0);
	glVertex3f(0, y, 0);
	glEnd();
	//front
	glBegin(type);
	glVertex3f(0, 0, z);
	glVertex3f(x, 0, z);
	glVertex3f(x, 0, 0);
	glVertex3f(0, 0, 0);
	glEnd();
	//back
	glBegin(type);
	glVertex3f(0, y, z);
	glVertex3f(x, y, z);
	glVertex3f(x, y, 0);
	glVertex3f(0, y, 0);
	glEnd();
	//bottom
	glBegin(type);
	glVertex3f(0, y, 0);
	glVertex3f(x, y, 0);
	glVertex3f(x, 0, 0);
	glVertex3f(0, 0, 0);
	glEnd();
}

void function::quad(GLenum gltype, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
	glBegin(gltype);
	glVertex2f(x1, y1);
	glVertex2f(x2, y2);
	glVertex2f(x3, y3);
	glVertex2f(x4, y4);
	glEnd();
}

void function::bezierQuad(float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4, float r, float g, float b) {
	float smoothness = 0.01;
	const int numberOfPoints = 500;
	float t;
	double xt[numberOfPoints], yt[numberOfPoints], xt2[numberOfPoints], yt2[numberOfPoints];
	int i;

	float x5 = -x1, x6 = -x2, x7 = -x3, x8 = -x4;

	for (i = 0, t = 0; t <= 1.0; i++, t += smoothness) {
		// left
		xt[i] = pow((1 - t), 3) * x1 + 3 * t * pow((1 - t), 2) * x2 + 3 * pow(t, 2) * (1 - t) * x3 + pow(t, 3) * x4;
		yt[i] = pow((1 - t), 3) * y1 + 3 * t * pow((1 - t), 2) * y3 + 3 * pow(t, 2) * (1 - t) * y3 + pow(t, 3) * y4;
		// right
		xt2[i] = pow((1 - t), 3) * x5 + 3 * t * pow((1 - t), 2) * x6 + 3 * pow(t, 2) * (1 - t) * x7 + pow(t, 3) * x8;
	}

	// border
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

void function::bezier(GLenum type, float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4) {
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