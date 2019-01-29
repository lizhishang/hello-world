package servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            18:54 2019-01-28
 */
public class WebContext {
    private List<Entity> entities;
    private List<Mapping> mappings;
//    Key --> servlet-name, Value --> classname
    private Map<String, String> entityMaps;
//    Key --> url-pattern, Value --> servlet-name
    private Map<String, String> mappingMaps;

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;
        entityMaps = new HashMap<>();
        mappingMaps = new HashMap<>();

        for(Entity entity : entities) {
            entityMaps.put(entity.getName(), entity.getClz());
        }
        for(Mapping mapping : mappings) {
            for (String pattern : mapping.getPattern()){
                mappingMaps.put(pattern, mapping.getName());
            }
        }
//        System.out.println(entityMaps);
//        System.out.println(mappingMaps);
    }

    public String getClassName(String pattern) {
//        System.out.println(entityMaps.get(mappingMaps.get(pattern)));
        return entityMaps.get(mappingMaps.get(pattern));
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
    }
}
