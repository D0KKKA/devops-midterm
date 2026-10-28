#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG_FILE="$ROOT_DIR/logs/Kukurekin_Danil_system_report.log"
ANALYSIS_FILE="$ROOT_DIR/logs/Kukurekin_Danil_log_analysis.txt"

grep -i "Kukurekin" "$LOG_FILE" > "$ANALYSIS_FILE"
echo "Search results saved to $ANALYSIS_FILE"
