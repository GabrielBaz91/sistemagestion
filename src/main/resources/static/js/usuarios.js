// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios()
     $('#usuarios').DataTable();
});
   async function cargarUsuarios(){

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
 });
  const usuarios = await request.json();


let listadoHtml = '';

for(let usuario of usuarios){

let telefonoT = usuario.Telefono == null ?'-' : usuario.telefono;

let botonEliminar ='<a href="#" onclick ="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i> </a>'
let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+ usuario.apellido
+'</td><td>'+usuario.email
+'</td><td>'+telefonoT+'</td><td>'+botonEliminar+'</td></tr>'

listadoHtml += usuarioHtml;

}

document.querySelector ("#usuarios tbody").outerHTML = listadoHtml;

}

function eliminarUsuario(id) {
    if (confirm('¿Desea Eliminar usuario?')) {
        fetch('api/usuarios/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            console.log("Respuesta:", response.status);
            if (response.ok) {
                alert("Usuario eliminado");
                location.reload();
            } else {
                alert("Error: " + response.status);
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Error en la solicitud");
        });
    }
}
