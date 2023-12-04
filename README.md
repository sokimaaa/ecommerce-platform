# E-commerce platform project
See [description](./TASK.md).

## Technologies

## Decisions

- [Architecture](supplement/documentation/Architecture.md)
- [Guidelines](supplement/guideline/README.md)

## Bootstrapping the platform

### Single Service Build & Run
First of all need to be built snapshots and pushed to local repo by 
```
mvn clean install
```

Then build the bootstrap module by
```
mvn clean package
```

Then build docker image by
```
docker build -t mic-<code>-image -f ./src/main/Dockerfile.optimal .
```

Now, just run the docker image by 
```
docker run --name mic-<code>-containter -d --rm -p $DEFAULT_PORT:$DEFAULT_PORT mic-<code>-image
```

### Entire Platform Build & Run
Build all artifacts as described at first steps of [Single Service Build & Run](#single-service-build--run).

Now, just run [docker compose](./bootstrap/docker-compose.yaml) by
```
docker-compose up -d
```

> Be aware from which directory you execute command

## Port Standardization

| Component | Default port | Instance port pattern |
|-----------|--------------|-----------------------|
| EIMS      | `8000`       | `80XX`                |
| EOMS      | `8100`       | `81XX`                |
| EPCS      | `8200`       | `82XX`                |
| EPGS      | `8300`       | `83XX`                |
| ESCS      | `8400`       | `84XX`                |
| EUMS      | `8500`       | `85XX`                |

## Where to find

- [Deployment](supplement/)
- [Tests](supplement/)
- [Monitoring](supplement/)
- [Endpoints](supplement/documentation/Endpoint.md)
- [Procedure](supplement/documentation/Procedure.md)
- [Configurations](supplement/)
- [Profiles](supplement/)
