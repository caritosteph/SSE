/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
                $('#fullname').editable({
                    url: '/post',
                    title: 'Ingrese Mensaje:',
                });
                $('#box').editable({
                    url: '/post',
                    type: 'text',
                    pk: 1,
                    name: 'Mensaje',
                    title: 'Ingrese Mensaje:'
                });
            });