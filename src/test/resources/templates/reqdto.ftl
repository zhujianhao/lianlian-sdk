${packageName}

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotNull;

import java.io.Serializable;


/**
* ${desc}
*/
@Data
public class ${reqClassName} implements Serializable{
<#list reqFieldList as field>
    /**
    * ${field["fieldDesc"]}
    */
    private String ${field["fieldName"]};
</#list>
}
