logSummary(){
        echo "completed suucessfully"
}

kubectl apply -f namespace.yaml
kubectl config set-context --current --namespace=app-space
kubectl apply -f simpleapp-1.yaml
kubectl apply -f simpleapp-2.yaml
kubectl apply -f simpleapp-3.yaml

logSummary