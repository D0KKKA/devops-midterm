#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG_FILE="$ROOT_DIR/logs/Kukurekin_Danil_system_report.log"

{
  echo "=== System report ==="
  echo "Student: Kukurekin Danil"
  echo "Group: it2-2312"
  echo "Student ID: 37554"
  echo "Date and time: $(date '+%Y-%m-%d %H:%M:%S %Z')"
  echo "Username: $(whoami)"
  echo "Operating system: $(uname -s)"
  echo "Kernel version: $(uname -r)"
  echo "CPU information:"
  if command -v lscpu >/dev/null 2>&1; then lscpu | head -n 12; else sysctl -n machdep.cpu.brand_string 2>/dev/null || uname -m; fi
  echo "Memory information:"
  if command -v free >/dev/null 2>&1; then free -h; else vm_stat 2>/dev/null | head -n 8 || true; fi
  echo "Disk usage:"
  df -h
  echo "Available disk space: $(df -h "$ROOT_DIR" | awk 'NR==2 {print $4}')"
  echo
} >> "$LOG_FILE"

echo "Report saved to $LOG_FILE"
