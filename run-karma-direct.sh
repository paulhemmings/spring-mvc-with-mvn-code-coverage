#!/usr/bin/env bash

# client side tests - jasmine / karma / phantomJS
# http://karma-runner.github.io/0.10/index.html
# http://jasmine.github.io/

echo "installs node modules. Will do nothing if already there"
npm install

echo "running all client side tests"
./node_modules/karma/bin/karma start ./src/test/webapp/karma.config.js