<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
<style>
  .movie-ticket {
    width: 600px;
    margin: 15px;
    padding: 10px;
    border: 1px solid #000000;
  }

  .logo {
    font-family: 'Pacifico', cursive;
  }

  .movie-title {
    display: block;
    margin: 5px 25px 0 25px;
    padding: 5px 10px;
    text-align: center;
    border-bottom: 2px solid #000;
  }

  .movie-date-place {
    overflow: hidden;
  }

  .movie-date-place col:first-child {
    width: 40%;
    float: left;
    border-right: 2px solid #000;
  }
</style>

<div class="movie-ticket">
  <h1 class="logo">TnA Theaters</h1>
  <div>
    <svg class="barcode"
         jsbarcode-format="code39"
         jsbarcode-value="${booking.seatNo}"
         jsbarcode-textmargin="0"
         jsbarcode-height="50"
         jsbarcode-margin="0"
         jsbarcode-fontoptions="bold" height="25px">
    </svg>
  </div>
  <h1 class="movie-title">${booking.movie.title}</h1>
  <div class="movie-date-place">
    <p>Date: ${booking.show.showDate}</p>
    <p>Time: ${booking.show.showTimeStart}
      to ${booking.show.showTimeEnd}</p>
    <p>Theater: ${booking.theater.title}</p>
    <p>Ticket Price: TK 350</p>
  </div>
  <h3>Ticket Serial Number: ${booking.seatNo}</h3>
</div>