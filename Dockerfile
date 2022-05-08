#FROM public.ecr.aws/docker/library/openjdk:17
#WORKDIR /opt/app
#ARG JAR_FILE=/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM public.ecr.aws/docker/library/openjdk:17
WORKDIR /myapp
COPY target/springboot-0.0.1-SNAPSHOT.jar /myapp/my-app.jar
ENTRYPOINT ["java","-jar","my-app.jar"]