# Demonstration commands

Run these commands from the project root. They are the required terminal evidence.

## Linux

```bash
tree -a
./scripts/Kukurekin_Danil_system_report.sh
chmod 744 scripts/Kukurekin_Danil_system_report.sh
ls -l scripts/Kukurekin_Danil_system_report.sh backups/Kukurekin_Danil_README.md
tail -n 5 logs/Kukurekin_Danil_system_report.log
grep -i Kukurekin logs/Kukurekin_Danil_system_report.log > logs/Kukurekin_Danil_log_analysis.txt
ps aux | grep -i '[j]ava'
```

`>` creates or replaces a file. `>>` appends new output to the end of a file without removing earlier content.

## Git

```bash
git remote -v
git log --oneline --graph --all
git branch -a
git tag -n
```

Do not commit `.env`, passwords, or database credentials: a Git history is hard to erase and a public repository can expose secrets. Use Jenkins Credentials and environment variables instead.

## Docker

```bash
docker compose up --build -d
docker compose ps
docker compose logs app
docker inspect kukurekin-danil-student-api
docker compose exec app sh
docker compose stop app
docker compose start app
docker compose up --build -d app
```

PostgreSQL data is stored in the named `postgres_data` volume, so records remain when services restart.

## Jenkins

Create a Pipeline job named `Kukurekin_Danil_Student_API`, point it at the GitHub repository, and use `Jenkinsfile` from SCM. Configure JDK 17, execute `./gradlew`, and use an agent that has Docker access. The `pollSCM` trigger in the Jenkinsfile provides automatic polling; a GitHub webhook can also trigger a build after each push.

Continuous Integration builds and tests every change. Continuous Deployment additionally releases a successful change automatically. This project performs CI only.
