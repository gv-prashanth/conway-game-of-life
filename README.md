# conway-game-of-life
A Conway's Game of Life simulator. You can play around at <a href="#"> Conway Game of Life </a>

## Create a World
### URL
HOST/world
### HttpMethod
POST
### Request Body
{
    "cells": [
        [
		    {
                "alive": false
            },
			{
                "alive": false
            },
			{
                "alive": false
            },
			{
                "alive": false
            }
		],
		        [
		    {
                "alive": true
            },
			{
                "alive": false
            },
			{
                "alive": true
            },
			{
                "alive": false
            }
		],
		        [
		    {
                "alive": true
            },
			{
                "alive": true
            },
			{
                "alive": true
            },
			{
                "alive": false
            }
		],
		        [
		    {
                "alive": true
            },
			{
                "alive": false
            },
			{
                "alive": false
            },
			{
                "alive": false
            }
		]
    ]
}
### Sample Response Body
201 Status Code with location header containing the path of newly created world.

## Observe the world
### URL
HOST/world/{worldId}
### HttpMethod
GET
### Sample Response Body
{
    "cells": [
        [
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            }
        ],
        [
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            }
        ],
        [
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            }
        ],
        [
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            },
            {
                "alive": false
            }
        ]
    ]
}
