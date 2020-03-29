# simple-app-1

It is a simple application with two apis 
 1. /v1/hostanme - which returns the hostname
 2. /v1/process - this calls one more application if we pass environment variables
 
 This project helps in understanding the kubernetes services and interactions. Three different deployments configured in a way that first deployment pods/containers calls second deployed pods which calls 3rd deployment, chain stops here (IS_LAST_SERVICE=true)

## Deploy Kubernetes way 

1. Go to kubernetes directory then run sh kube-deploy.sh this created 3 different deployments

2. Wait for the cluster to orchastrate all objects

3. Run kubectl get services then check for external IP of LoadBalance type Service

4. Hit http://<externalip>/v1/process to check chain of calls
