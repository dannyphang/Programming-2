#pragma once

#include <Windows.h>
#include <gl/GL.h>
#include <gl/GLU.h>
#include <math.h>

#ifndef MY_CLASS_H // include guard
#define MY_CLASS_H

namespace N {
	class function {
	public:
		float xC(float x);
		float yC(float y);
		float zC(float z);
		float xP(float x);
		float yP(float y);
		float zP(float z);
		float cC(float color);
		void v3f(float x, float y, float z);
		void v2f(float x, float y);
		void color(char smallLetterColorChar);
		void poly3(GLenum type, float* array, int num);
		void sphere(GLenum type, float xradius, float yradius, float zradius, int xaxis, int yaxis, float zaxis, float xmin, float xmax, float ymin, float ymax, float r, float g, float b);
		void sphere(GLenum type, float radius, int slices, int stacks);
		void cylinder(GLenum type, float baseRadius, float topRadius, float height, int slices, int stacks);
		void circle(float x, float y, float xr, float yr, float min, float max);
		void circle(float x, float y, float z, float xr, float yr, float min, float max);
		void triangle(GLenum type, float base, float height, int lineWidth);
		void quad(GLenum type, float length, float height, int lineWidth);
		void pyramid(GLenum type, float size, int lineWidth);
		void cube(GLenum type, float size, int lineWidth);
		void cuboid(GLenum type, float size, float ratio, int lineWidth);
		void quad(GLenum gltype, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4);
		void bezierQuad(float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4, float r, float g, float b);
		void bezier(GLenum type, float x1, float x2, float x3, float x4, float y1, float y2, float y3, float y4);
		void disk(GLenum type, float innerRadius, float outerRadius, int slices, int loop);
	};
}

#endif /* MY_CLASS_H */