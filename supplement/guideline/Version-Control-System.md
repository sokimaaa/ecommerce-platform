# Version Control System Guidelines

Before pushing changes they must be formatted with [bundled code formatter](./formatting/.editorconfig).

## Branch Naming Conventions

- Branch name for production releases - `main`
- Branch name for "next release" development - `dev`
- Branch name for "release" development - `release`, format: `release/0.1.0`
- Branch name for new feature - `feat`, format: `feat/TASK-[task_number]`
- Branch name for fixes - `fix`, format: `fix/TASK-[task_number]`
- task_number - 1,2...50 etc.

## PR Naming Conventions

`[TASK-task_number] common changes description`

## Commit Naming Conventions

`[TASK-task_number] commit description`


## The overall flow of Gitflow is:

1. A `dev` branch is created from `main`

2. A `release` branch is created from `dev`

3. `Feat` branches are created from `dev`

4. When a `feat` is complete it is merged into the `dev` branch

5. When the `release` branch is done it is merged into `dev` and `main`

6. If an issue in main is detected a `fix` branch is created from `main`

7. Once the `fix` is complete it is merged to both `dev` and `main`
