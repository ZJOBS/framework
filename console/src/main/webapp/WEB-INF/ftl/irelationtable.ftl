<script type="text/javascript">
    jQuery(function ($) {
        var ${id}jqGridIrelation;

        var ${id}grid_selector = "#${id}-table";
        var ${id}pager_selector = "#${id}-pager";
        var relation = ${relation};
        var width = $("#${id}")[0].scrollWidth;
        //resize to fit page size
        $(window).on('resize.jqGrid', function () {
            $(${id}grid_selector).jqGrid('setGridWidth', 550);
        });



        function style_search_filters(form) {
            form.find('.delete-rule').val('X');
            form.find('.add-rule').addClass('btn btn-xs btn-primary');
            form.find('.add-group').addClass('btn btn-xs btn-success');
            form.find('.delete-group').addClass('btn btn-xs btn-danger');
        }

        function style_search_form(form) {
            var dialog = form.closest('.ui-jqdialog');
            var buttons = dialog.find('.EditTable');
            buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
            buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
            buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
        }

        //替换图标
        function updatePagerIcons(table) {
            var replacement = {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
            };
            $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
                if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
            })
        }

        //启用工具提示，jquery自己的方法
        function enableTooltips(table) {
            $('.navtable .ui-pg-button').tooltip({container: 'body'});
            $(table).find('.ui-pg-div').tooltip({container: 'body'});
        }

        //删除grid
        $(document).one('ajaxloadstart.page', function (e) {
            $.jgrid.gridDestroy(${id}grid_selector);
            $('.ui-jqdialog').remove();
        });



        $('body').delegate('input[name=' + relation[1] + ']', 'mousedown', function (e) {
            if (!${id}jqGridIrelation) {
                ${id}jqGridIrelation = jQuery(${id}grid_selector).jqGrid({
                    url: "${contextPath}${queryurl}",
                    datatype: "json", //数据来源，本地数据
                    autoencode: false,//取消自动编码
                    mtype: "POST",//提交方式
                    height: <#if height?exists>${height}<#else>'auto'</#if>,
                    colNames: [${columntitle}],
                    colModel: [${columnname}],
                    viewrecords: true,
                    rowNum: 15,
                    rowList: [5, 10, 15],
                    pager: ${id}pager_selector,
                    altRows: true,
                    //toppager: true,
                    multiselect: true,
                    //multikey: "ctrlKey",
                    multiboxonly: true,
                    caption: "${caption}",//顶上说明
                    onSelectRow: function (id) {
                        //选中后事件
                        var rowId = $(${id}grid_selector).jqGrid('getGridParam', 'selrow');
                        var rowData = $(${id}grid_selector).jqGrid('getRowData', rowId);
                        $('input[name=' + relation[1] + ']').val(rowData[relation[0]]);
                        //取消所有选项
                        // 关闭模板
                        $('#${id}Modal').modal('hide');
                    },
                    autowidth: true,
                });
                $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
                //navButtons
                jQuery(${id}grid_selector).jqGrid('navGrid', ${id}pager_selector,
                        { 	//navbar options
                            add: false,
                            edit: false,
                            del: false,
                            search: true,
                            searchicon: 'ace-icon fa fa-search orange',
                            refresh: true,
                            refreshicon: 'ace-icon fa fa-refresh green',
                        },
                        {},
                        {},
                        {},
                        {
                            //search form
                            recreateForm: true,
                            caption: "查询",
                            Find: "查找",
                            Reset: "重置",
                            odata: [{oper: 'eq', text: '等于'}, {oper: 'ne', text: '不等'}, {oper: 'lt', text: '小于'}, {
                                oper: 'le',
                                text: '小于等于'
                            }, {oper: 'gt', text: '大于'}, {oper: 'ge', text: '大于等于'}, {oper: 'bw', text: '开始于'}, {
                                oper: 'bn',
                                text: '不开始于'
                            }, {oper: 'in', text: '包含'}, {oper: 'ni', text: '不包含'}, {oper: 'ew', text: '结束于'}, {
                                oper: 'en',
                                text: '不结束于'
                            }, {oper: 'cn', text: '包含'}, {oper: 'nc', text: '不包含'}, {oper: 'nu', text: '空值'}, {
                                oper: 'nn',
                                text: '非空值'
                            }],
                            groupOps: [{op: "AND", text: "所有"}, {op: "OR", text: "任一"}],
                            afterShowSearch: function (e) {
                                var form = $(e[0]);
                                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                                style_search_form(form);
                            },
                            afterRedraw: function () {
                                style_search_filters($(this));
                            }
                            ,
                            multipleSearch: true,
                        }
                )
            }
            <#--jQuery(${id}grid_selector).jqGrid('filterToolbar',{-->
                <#--searchOperators : true,-->
                <#--odata: [{oper: 'eq', text: '等于'}, {oper: 'ne', text: '不等'}, {oper: 'lt', text: '小于'}, {-->
                    <#--oper: 'le',-->
                    <#--text: '小于等于'-->
                <#--}, {oper: 'gt', text: '大于'}, {oper: 'ge', text: '大于等于'}, {oper: 'bw', text: '开始于'}, {-->
                    <#--oper: 'bn',-->
                    <#--text: '不开始于'-->
                <#--}, {oper: 'in', text: '包含'}, {oper: 'ni', text: '不包含'}, {oper: 'ew', text: '结束于'}, {-->
                    <#--oper: 'en',-->
                    <#--text: '不结束于'-->
                <#--}, {oper: 'cn', text: '包含'}, {oper: 'nc', text: '不包含'}, {oper: 'nu', text: '空值'}, {-->
                    <#--oper: 'nn',-->
                    <#--text: '非空值'-->
                <#--}]-->
            <#--});//表格中添加 搜索栏，方便使用，但不美观，先关闭-->
            //刷新
            $(${id}grid_selector).trigger("reloadGrid");

            <#--$('#${id}').dialog();-->

            $('#${id}Modal').modal('show');
        });
    });
</script>

<!-- Modal -->
<div class="modal fade" id="${id}Modal" tabindex="2" role="dialog" aria-labelledby="${id}ModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="${id}ModalLabel">关联</h4>
            </div>
            <div id="${id}" class="modal-body">
                <table id="${id}-table" class="table table-striped table-bordered table-hover"></table>
                <div id="${id}-pager"></div>
            </div>
        </div>
    </div>
</div>


