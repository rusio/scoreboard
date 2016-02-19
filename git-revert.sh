#!/bin/bash

set -e
echo "Full git reset"
git reset --hard
git clean -f