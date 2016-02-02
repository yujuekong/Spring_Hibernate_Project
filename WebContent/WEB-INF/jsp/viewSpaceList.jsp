<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>景区列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datatables/dataTables.jqueryui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datatables/jquery-ui.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatables/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatables/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datatables/dataTables.jqueryui.js"></script>
<script type="text/javascript">
	$(document).ready( function () {
	    $('#table_id').dataTable({
	    	"ajax":"${pageContext.request.contextPath}/viewManager/list.html",
	    	"columns": [
	    	            { "data": "spaceName","sClass":"center"},
	    	            { "data": "website","sClass":"center" },
	    	            { "data": "address","sClass":"center" },
	    	            { "data": "description","sClass":"center"  }
	    	        ],
	        "oLanguage": {
                "sProcessing": "正在加载中......",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "对不起，查询不到相关数据！",
                "sEmptyTable": "表中无数据存在！",
                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
                "sSearch": "搜索",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "末页"
                }
            } //多语言配置
	    });
	} );
</script>
	
</head>
<body>
<div class="container">
	<table id="table_id" class="display" cellspacing="0" width="100%">
	<thead>
        <tr>
            <th class="center">景区名称</th>
            <th class="center">景区网址</th>
            <th class="center">景区地址</th>
            <th class="center">景区描述</th>
        </tr>
    </thead>
    <tbody>
        
    </tbody>
	</table>
</div>
	
</body>
</html>