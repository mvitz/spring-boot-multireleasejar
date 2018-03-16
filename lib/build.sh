#!/usr/bin/env bash

set -euo pipefail
IFS=$'\n\t'

rm -rf out
mkdir -p out/META-INF/versions/9

javac --release 8 -d out java8/Greeter.java
javac -d out/META-INF/versions/9 java9/Greeter.java

cd out
jar cmf ../MANIFEST.MF ../multi.jar .
cd ..

mvn install:install-file -Dfile=multi.jar -DgroupId=com.innoq -DartifactId=spring-multijar-lib -Dversion=0.0.1 -Dpackaging=jar

