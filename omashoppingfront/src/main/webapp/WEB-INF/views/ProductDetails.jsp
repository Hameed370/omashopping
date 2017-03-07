<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <title>All Product Page</title> -->
<!-- <s:url value="/resources/css/" var="css" /> -->
<!-- <s:url value="/resources/js/" var="js" /> -->
<!-- <s:url value="/resources/Images" var="imgs" /> -->
<%-- <link href="${css}bootstrap.css" rel="stylesheet"> --%>
<%-- <link href="${css }dataTables.bootstrap.css" rel="stylesheet"> --%>
<%-- <link href="${css}bootstrap-glyphicons.css" rel="stylesheet"> --%>
<%-- <script type="text/javascript" src="${js}jquery-3.1.1.js"></script> --%>
<%-- <script type="text/javascript" src="${js}bootstrap.min.js"></script> --%>
<%-- <script type="text/javascript" src="${js}jquery.dataTables.js"></script> --%>
<%-- <script type="text/javascript" src="${js }dataTVables.bootstrap.js"></script> --%>
<%-- <script type="text/javascript" src="${js}modernizr-2.6.2.min.js"></script> --%>
<%-- <script type="text/javascript" src="${js}mytable.js"></script> --%>

<!-- </head> -->

<script>
$(function(){
	
	$('#mytable').DataTable( {
		ajax: {
	        url: '/omashoppingfront/products/all',
	        dataSrc: ''
	    },
	    columns: [
	       
	        { data: 'id' },
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<img src="/omashoppingfront/resources/images/'+ row.id +'.jpg" height="50" width="50">';
	            }
	        },
	        { data: 'pname' },
	        { data: 'description' },
	        {data: 'price'},
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<a class="btn btn-primary" href="/omashoppingfront/show/'+row.id+'/product">View Item</a> &nbsp;<a class="btn btn-primary" href="'+data+'">Add To Cart</a> ';
	            }	
	        }
	        
	        
	    ]
	} );
	
	
	
});


</script>




<div class="container">
	<div class="row">
		<table id="mytable" class="table table-striped">
			<thead>
				<!-- 	<th>image name</th> -->
				<!-- 	<th>active</th> -->
				<th>PTAG</th>
				<th>Image</th>
				<th>PNAME</th>
				<th>Description</th>
				<th>Price</th>
				<th>Link</th>
			</thead>
		</table>
	</div>
</div>
