#!/bin/bash

set -e
echo "Fully reverting to last commit..."
git reset --hard
git clean -f