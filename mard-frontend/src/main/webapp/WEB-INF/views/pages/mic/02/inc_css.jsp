<style type="text/css">
    .word-bg {
        background: rgb(204,204,204); 
        padding-top: 10px;
        padding-bottom: 1px;
    }
    page {
        background: white;
        display: block;
        margin: 0 auto;
        margin-bottom: 0.5cm;
        box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
    }
    page[size="A4"] {  
        width: 25cm;
        min-height: 29.7cm; 
        height: auto;
        font-family: "Time";
        font-size: 13pt !important;
    }
    @media print {
        body, page {
            margin: 0;
            box-shadow: 0;
        }
    }

    .a4-padding{
        padding: 1cm 1cm 1cm 1cm;
        box-sizing: border-box;
    }
    .t-center{
        text-align: center;
    }
    .t-bold{
        font-weight: bold;
    }
    .t-normal{
        font-weight: normal;
    }
    .t-italic{
        font-style: italic;
    }
    .left{
        float: left;
    }
    .right{
        float: right;
    }
    .w35p{
        width: 35%;
        max-width: 35%;
        min-width: 35%;
    }
    .w40p{
        width: 40%;
        max-width: 40%;
        min-width: 40%;
    }
    .w60p{
        width: 60%;
        max-width: 60%;
        min-width: 60%;
    }
    .w50p{
        width: 50%;
        max-width: 50%;
        min-width: 50%;
    }
    .w100p{
        width: 100%;
        max-width: 100%;
        min-width: 100%;
    }

    .tb-none-border{
        border: none !important;
    }
    .tb-none-border td, tr{
        border: none !important;
    }
    p.title{
        width: 100%;
        font-weight: bold;
        text-transform: uppercase;
        text-align: center;
        padding-top: 1.2cm;
    }
    p.code{
        font-size: 90%;
        /*        font-style: italic;*/
        width: 100%;
        text-align: center;
    }
    p.content{
        width: 100%;
    }
    .tb-content {
        border-collapse: collapse;
        border: 1px solid black;
    }

    .tb-content th, td {
        border: 0px solid black;
        padding: 5px;
    }
    .tb-content th{
        text-align: center;
        font-weight: bold;
    }
    .pb-long{
        padding-bottom: 100px;
    }
    .pt-10{
        padding-top: 10px;
    }
    .nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus{
        color: #555555;
        background-color: #fff;
        border: none;
        border-bottom-color: transparent;
        cursor: default;
        display:inline-block;
    }
    .tabbable-custom > .nav-tabs > li.active{
        border-top: 3px solid #ed6b75;
        margin-top: 0;
        position: relative;
        background-color: #fff;
        border-left: 1px solid #ddd;
        border-right:1px solid #ddd;
        border-bottom-color: transparent;
        color: #555555;
        cursor: default;
    }
    .nav-tabs > li {
        position:relative;
    }
    .nav-tabs > li > a {
        display:inline-block;
    }
    .nav-tabs > li > span {
        display:none;
        color: red;
    }
    .nav-tabs > li.active > span {
        display: inline-block;
    }
    table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}
</style>