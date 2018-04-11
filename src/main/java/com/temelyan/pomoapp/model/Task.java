package com.temelyan.pomoapp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TASKS",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"name", "project_id"},
                name = "task_unique_name_project"))
public class Task extends AbstractEntity {
    private String name;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<Pomo> pomos;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pomo> getPomos() {
        return pomos;
    }

    public void setPomos(List<Pomo> pomos) {
        this.pomos = pomos;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        if (!super.equals(o)) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(pomos, task.pomos) &&
                Objects.equals(project.getId(), task.project.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, pomos, project.getId());
    }
}
