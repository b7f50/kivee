package pl.alfons.app.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskForm {
    private String name;
    private String description;
}
