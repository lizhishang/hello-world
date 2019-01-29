package servlet;

import java.util.HashSet;
import java.util.Set;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            16:31 2019-01-28
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<String>();
    }

    public Mapping(String name, Set<String> pattern) {
        this.name = name;
        this.patterns = pattern;
    }

    public void addPattern(String pattern){
        this.patterns.add(pattern);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPattern() {
        return patterns;
    }

    public void setPattern(Set<String> pattern) {
        this.patterns = pattern;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "name='" + name + '\'' +
                ", patterns=" + patterns +
                '}';
    }
}
