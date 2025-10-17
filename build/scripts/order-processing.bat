@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  order-processing startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and ORDER_PROCESSING_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\order-processing-1.0.0-plain.jar;%APP_HOME%\lib\ch-smpp-5.0.9.jar;%APP_HOME%\lib\spring-boot-starter-webflux-3.2.3.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-reactive-3.2.3.jar;%APP_HOME%\lib\spring-boot-starter-actuator-3.2.3.jar;%APP_HOME%\lib\micrometer-jakarta9-1.12.3.jar;%APP_HOME%\lib\micrometer-core-1.11.2.jar;%APP_HOME%\lib\akka-actor_2.13-2.6.21.jar;%APP_HOME%\lib\grpc-netty-shaded-1.59.0.jar;%APP_HOME%\lib\grpc-protobuf-1.59.0.jar;%APP_HOME%\lib\grpc-stub-1.59.0.jar;%APP_HOME%\lib\spring-boot-starter-json-3.2.3.jar;%APP_HOME%\lib\spring-boot-starter-3.2.3.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-3.2.3.jar;%APP_HOME%\lib\spring-webflux-6.1.4.jar;%APP_HOME%\lib\spring-web-6.1.4.jar;%APP_HOME%\lib\mongodb-driver-reactivestreams-4.11.1.jar;%APP_HOME%\lib\reactor-netty-http-1.1.16.jar;%APP_HOME%\lib\reactor-netty-core-1.1.16.jar;%APP_HOME%\lib\reactor-core-3.6.3.jar;%APP_HOME%\lib\spring-data-mongodb-4.2.3.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-3.2.3.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.2.3.jar;%APP_HOME%\lib\spring-boot-actuator-3.2.3.jar;%APP_HOME%\lib\spring-boot-3.2.3.jar;%APP_HOME%\lib\spring-context-6.1.4.jar;%APP_HOME%\lib\micrometer-observation-1.12.3.jar;%APP_HOME%\lib\micrometer-commons-1.12.3.jar;%APP_HOME%\lib\HdrHistogram-2.1.12.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\scala-java8-compat_2.13-1.0.0.jar;%APP_HOME%\lib\scala-library-2.13.8.jar;%APP_HOME%\lib\config-1.4.2.jar;%APP_HOME%\lib\grpc-util-1.59.0.jar;%APP_HOME%\lib\grpc-core-1.59.0.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.59.0.jar;%APP_HOME%\lib\grpc-context-1.59.0.jar;%APP_HOME%\lib\grpc-api-1.59.0.jar;%APP_HOME%\lib\guava-32.0.1-android.jar;%APP_HOME%\lib\error_prone_annotations-2.20.0.jar;%APP_HOME%\lib\perfmark-api-0.26.0.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\proto-google-common-protos-2.22.0.jar;%APP_HOME%\lib\protobuf-java-3.24.0.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.2.3.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-tx-6.1.4.jar;%APP_HOME%\lib\spring-data-commons-3.2.3.jar;%APP_HOME%\lib\spring-aop-6.1.4.jar;%APP_HOME%\lib\spring-beans-6.1.4.jar;%APP_HOME%\lib\spring-expression-6.1.4.jar;%APP_HOME%\lib\spring-core-6.1.4.jar;%APP_HOME%\lib\snakeyaml-2.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.15.4.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.15.4.jar;%APP_HOME%\lib\jackson-annotations-2.15.4.jar;%APP_HOME%\lib\jackson-core-2.15.4.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.15.4.jar;%APP_HOME%\lib\jackson-databind-2.15.4.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\mongodb-driver-core-4.11.1.jar;%APP_HOME%\lib\bson-record-codec-4.11.1.jar;%APP_HOME%\lib\bson-4.11.1.jar;%APP_HOME%\lib\logback-classic-1.4.14.jar;%APP_HOME%\lib\log4j-to-slf4j-2.21.1.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.12.jar;%APP_HOME%\lib\slf4j-api-2.0.12.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-qual-3.33.0.jar;%APP_HOME%\lib\j2objc-annotations-2.8.jar;%APP_HOME%\lib\gson-2.10.1.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.23.jar;%APP_HOME%\lib\spring-jcl-6.1.4.jar;%APP_HOME%\lib\netty-codec-http2-4.1.107.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.107.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.107.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.107.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.107.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.107.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.107.Final-linux-x86_64.jar;%APP_HOME%\lib\logback-core-1.4.14.jar;%APP_HOME%\lib\log4j-api-2.21.1.jar;%APP_HOME%\lib\netty-handler-4.1.107.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.107.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.107.Final.jar;%APP_HOME%\lib\netty-codec-4.1.107.Final.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.107.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.107.Final.jar;%APP_HOME%\lib\netty-transport-4.1.107.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.107.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.107.Final.jar;%APP_HOME%\lib\netty-common-4.1.107.Final.jar


@rem Execute order-processing
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ORDER_PROCESSING_OPTS%  -classpath "%CLASSPATH%" com.hacom.orders.Application %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable ORDER_PROCESSING_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%ORDER_PROCESSING_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
