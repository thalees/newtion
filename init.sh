#!/usr/bin/env bash

set -e

COMMAND=${1:-"web"}
echo $COMMAND

case "$COMMAND" in
  migrate|web)
    exec java -Xms380m \
      -Duser.Timezone=America/Sao_Paulo \
      -Dserver.port=8080 \
      -Dspring.datasource.url="${DATABASE_URL}" \
      -jar /app/newtion.jar \
      $COMMAND
    ;;
  *)
    exec sh -c "$*"
    ;;
esac
