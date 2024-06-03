## Создание docker image

```
docker build -t license-provider --no-cache .
```

### Создайте папку на сервере для фронта
### Скопируйте фронт в созданную папку 
### Используйте папку во время создания контейнера

```
docker run -d -p 777:8080 -v /opt/license-provider/front:/front --restart always --name=license_provider license-provider
```

