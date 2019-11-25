# Newtion

Setup
---
To start the application just run the command below to build the application:

```
./gradlew build
```

With everything installed, it is necessary to upload the `database`(**PostgreSQL**) that is in the `docker`:

```
docker-compose build
docker-compose up
```

Finally, just run the application! :tada:

Possible errors:
---

**Error:**
> JDK not being recognized:

**Solution:**
Download version: 11.0.4 https://bell-sw.com/pages/java-11.0.4/

**Error:**
> Failed to load module "canberra-gtk-module"

**Solution:**
https://blog.welrbraga.eti.br/?p=3072
