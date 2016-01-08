module.exports = function(grunt) {

    // Configuration goes here

    grunt.initConfig({

        pkg: grunt.file.readJSON('package.json'),

        karma: {
            unit: {
                configFile: './src/test/webapp/karma.config.js',
                plugins:[
                    'karma-jasmine',
                    'karma-coverage',
                    'karma-chrome-launcher',
                    'karma-phantomjs-launcher'
                ] 
            }
        },

        concat: {
            dist: {
                src: [
                    './src/main/webapp/public/scripts/*.js', // All public scripts
                    './src/main/webapp/app/**/*.js'   // All the app scripts
                ],
                dest: './src/main/webapp/build/production.js'
            }
        },

        uglify: {
            build: {
                src: './src/main/webapp/build/production.js',
                dest: './src/main/webapp/build/production.min.js'
            }
        },

        maven: {
            options: {
                groupId: 'com.razor.SpringMvcCoverage'
            },
            test: {
                options: {
                    goal: 'cobertura:cobertura'
                },
                src: [ '**', '!node_modules/**' ]
            },
            deploy: {
                options: {
                    goal: 'deploy',
                    url: 'file://snapshot-repo'
                },
                src: [ '**', '!node_modules/**' ]
            },
            src: [ '**', '!node_modules/**' ]
        }

    });

    // Load plugins

    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-maven-tasks');

    // Define default task

    grunt.registerTask('default', ['karma' ]);

    // Define additional tasks

    grunt.registerTask('test', ['karma', 'maven:test']);
    grunt.registerTask('pre-deploy', ['concat', 'uglify']);

};




