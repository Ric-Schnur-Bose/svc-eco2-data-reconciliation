#!/bin/bash

set -e

# health endpoint?
curl --fail -v eco2-data-transport-batch-core:9090/health_check

