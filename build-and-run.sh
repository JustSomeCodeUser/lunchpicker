#!/bin/bash

mvn clean package
docker build -t lunchpicker .
docker run -p 8888:8888 lunchpicker
