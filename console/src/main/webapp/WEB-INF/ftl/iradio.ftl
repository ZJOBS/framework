<div class="radio">
    <#list options as option>
        <label>
            <input name="form-field-radio" type="radio" class="ace" value="${option.value}">
            <span class="lbl">${option.name}</span>
        </label>
    </#list>
</div>