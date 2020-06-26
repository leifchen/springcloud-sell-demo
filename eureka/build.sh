#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t leifchen/sell-eureka .

docker push leifchen/sell-eureka