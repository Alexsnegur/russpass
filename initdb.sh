#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 -U "postgres" -d "russpass" <<-EOSQL

    CREATE ROLE postgres with SUPERUSER PASSWORD '24812';

EOSQL