#!/bin/bash

kubectl create deployment web-server --image=thanhvv/icommerce-web-server
kubectl expose deployment web-server --type=NodePort --port=4200

kubectl create deployment product-service --image=thanhvv/icommerce-product-service
kubectl expose deployment product-service --type=NodePort --port=8000

kubectl create deployment order-service --image=thanhvv/icommerce-order-service
kubectl expose deployment order-service --type=NodePort --port=9000

read -p "Waiting for the pods are running..." 300

kubectl port-forward service/web-server 4200:4200
kubectl port-forward service/product-service 8000:8000
kubectl port-forward service/order-service 9000:9000
