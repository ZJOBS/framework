<div class="bootstrap-duallistbox-container row moveonselect">
    <div class="box1 col-md-6">
        <label for="bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]" style="display: none;"></label>
        <span class="info-container">
                    <span class="info">绑定</span>
                    <button type="button" class="btn clear1 pull-right btn-default btn-xs btn-white btn-bold btn-info">show all</button>
                </span>
        <input class="filter form-control" type="text" placeholder="Filter">
        <div class="btn-group buttons">
            <button type="button" class="btn moveall btn-white btn-bold btn-info" title="Move all">
                <i class="fa fa-arrow-right"></i>
                <i class="fa fa-arrow-right"></i>
            </button>
            <button type="button" class="btn move btn-white btn-bold btn-info" title="Move selected">
                <i class="fa fa-arrow-right"></i>
            </button>
        </div>
    <#--添加左侧部分-->
        <select multiple="multiple" id="bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]"
                class="form-control" name="duallistbox_demo1[]_helper1" style="height: 199px;">
            <option value="option1">Option 1</option>
            <option value="option2">Option 2</option>
            <option value="option3" selected="selected">Option 3</option>
            <option value="option4">Option 4</option>
            <option value="option5">Option 5</option>
            <option value="option6" selected="selected">Option 6</option>
            <option value="option7">Option 7</option>
            <option value="option8">Option 8</option>
            <option value="option9">Option 9</option>
            <option value="option0">Option 10</option>
        </select>
    </div>
    <div class="box2 col-md-6">
        <label for="bootstrap-duallistbox-selected-list_duallistbox_demo1[]" style="display: none;"></label>
        <span class="info-container">
                    <span class="info">未绑定</span>
                    <button type="button" class="btn clear2 pull-right btn-default btn-xs btn-white btn-bold btn-info">show all</button>
                </span>
        <input class="filter form-control" type="text" placeholder="Filter">
        <div class="btn-group buttons">
            <button type="button" class="btn remove btn-white btn-bold btn-info" title="Remove selected">
                <i class="fa fa-arrow-left"></i>
            </button>
            <button type="button" class="btn removeall btn-white btn-bold btn-info" title="Remove all">
                <i class="fa fa-arrow-left"></i> <i class="fa fa-arrow-left"></i>
            </button>
        </div>
    <#--添加右侧部分-->
        <select multiple="multiple" id="bootstrap-duallistbox-selected-list_duallistbox_demo1[]"
                class="form-control" name="duallistbox_demo1[]_helper2" style="height: 199px;"></select>
    </div>
</div>