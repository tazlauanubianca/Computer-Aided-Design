# CAD

## Description
CAD (Computer-Aided Design or Computer-Aided Design and Drafting) is the use of technology to create designs (usually 2D) and replaces the process of manually drawing a piece with an automated one. One of the most popular programs is AutoCAD. Such programs improve the quality of the design and the productivity of the designer.

The current project is a MiniCAD program that implements the same principles of a CAD software used in the daily life of thousands of companies and is able to produce different geometric shapes, in different positions and in different colors.

## Input data
The name of the input file from which it is read is received as a program argument. Input files will have the following structure:

On the first line you will find a natural number N, representing the total number of shapes that will be in the drawing.
The following N lines will contain information about each of the N shapes: the position of a shape, its dimensions and color.
The colors you will have to use will be rendered in the format: " #RGB A ", where R, G and B represent the values of the Red, Green and Blue pixels in hex format (256 possible values: 00, 01, 02, ... , 09, 0A, 0B, ..., 0F, 10, 11, ..., FE, FF), and A represents the Alpha (opacity) value in decimal format, being able to take integer values from 0 to 100.

Of course, each shape is different, so it will have a different format. The possibilities are as follows:

* Background:
`CANVAS <height> <width> #RGB A`

* Line:
`LINE <start x coordinate> <start y coordinate> <end x coordinate> <end y coordinate> #RGB A`

* Square:
`SQUARE <upper left corner coordinate> <upper left corner coordinate> <side dimension> #RGB A #RGB A`

* Rectangle:
`RECTANGLE <upper left corner corner coordinate> <upper left corner corner coordinate> <height dimension> <length dimension> #RGB A #RGB A`

* Circle:
`CIRCLE <center coordinate> <center coordinate> <race> #RGB A #RGB A`

* Triangle:
`TRIANGLE <coordinate to the first point> <coordinate to the first point> <coordinate to the second point> <coordinate to the second point> <coordinate to the third point> <coordinate to the second third point> #RGB A #RGB A`

* Diamond:
`DIAMOND <center x coordinate> <center coordinate> <horizontal diagonal dimension> <vertical diagonal dimension> #RGB A #RGB A`

* Polygon
`POLYGON <number of points> (number of points) * (<coordinate of a point> <coordinate of a point>) #RGB A #RGB A`
