#!/bin/sh

ACTIVE_PROFILE="${PROFILE:-dev}"

echo "ACTIVE_PROFILE=${ACTIVE_PROFILE}"

exec java -Dspring.profiles.active=${ACTIVE_PROFILE} \
          -jar app.jar