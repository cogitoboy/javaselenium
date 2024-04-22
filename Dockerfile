FROM maven:3.9.6-eclipse-temurin-21-alpine

ARG ALLURE_VERSION=2.27.0

WORKDIR /test_automation
COPY src ./src
COPY pom.xml .

RUN apk update && \
  apk upgrade
  
RUN wget "https://github.com/allure-framework/allure2/releases/download/$ALLURE_VERSION/allure-$ALLURE_VERSION.zip"
RUN jar xvf "allure-$ALLURE_VERSION.zip"
RUN rm "allure-$ALLURE_VERSION.zip"
RUN chmod u+x "allure-$ALLURE_VERSION/bin/allure"

ENV ALLURE_HOME="/test_automation/allure-$ALLURE_VERSION"
ENV PATH="$PATH:$ALLURE_HOME/bin"  

RUN mvn install -DskipTests