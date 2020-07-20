</main>
	
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <!-- Datatables -->
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script>
	    $(document).ready(function() {
	    	
	    	console.info('Documento HTML cargado y listo para ejecutar nuestro Script');
	    	
	    	console.debug('Habilitar popover de Bootstrap');
	    	$('[data-toggle="popover"]').popover();
	    	
	    	console.debug('Habilitar Plugin Datatables');
	        $('#example').DataTable({
	        	"language": {
	        		"sProcessing":     "Procesando...",
	        	    "sLengthMenu":     "Mostrar _MENU_ registros",
	        	    "sZeroRecords":    "No se encontraron resultados",
	        	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
	        	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        	    "sInfoPostFix":    "",
	        	    "sSearch":         "Filtrar:",
	        	    "sUrl":            "",
	        	    "sInfoThousands":  ",",
	        	    "sLoadingRecords": "Cargando...",
	        	    "oPaginate": {
	        	        "sFirst":    "Primero",
	        	        "sLast":     "Último",
	        	        "sNext":     "Siguiente",
	        	        "sPrevious": "Anterior"
	        	    },
	        	    "oAria": {
	        	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	        	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        	    },
	        	    "buttons": {
	        	        "copy": "Copiar",
	        	        "colvis": "Visibilidad"
	        	    }
	        	}
	        });
	    } );
    </script> 
  </body>
</html>