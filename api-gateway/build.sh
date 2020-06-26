#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t leifchen/sell-api-gateway .

docker push leifchen/sell-api-gateway