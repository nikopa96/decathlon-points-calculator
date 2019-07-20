<template>
  <div v-if="sports">
    <navbar></navbar>
    <div class="container">
      <div class="card">
        <div class="card-header">Calculator</div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6 info-column">
              <form class="needs-validation" @submit.prevent="submit">
                <div class="form-group">
                  <label for="chooseSport">Choose sport:</label>
                  <select class="custom-select" id="chooseSport" v-model="chosenSport">
                    <option v-for="sport in sports" v-bind:key="sport.id" v-bind:value="sport">
                      {{ sport.name }}
                    </option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="enterResult">Result:</label>
                  <div class="input-group">
                    <input type="number" step="any" class="form-control" aria-describedby="result" id="enterResult"
                           v-model="chosenResult" autocomplete="off">
                    <div class="input-group-append">
                      <span class="input-group-text" id="result">{{ chosenSport.unit }}</span>
                    </div>
                  </div>
                </div>
                <button type="submit" class="btn btn-secondary">Calculate</button>
              </form>
            </div>
            <div class="col-md-6 info-column">
              <div>Points: </div>
              <h1> {{ pointScore.points }} </h1>
              <div v-if="pointScore.sport.coefficientA">
                <div>{{ 'A: ' + pointScore.sport.coefficientA }}</div>
                <div>{{ 'B: ' + pointScore.sport.coefficientB }}</div>
                <div>{{ 'C: ' + pointScore.sport.coefficientC }}</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="card">
        <div class="card-header">Formula</div>
        <div class="card-body">
          <div class="formula-block">
            <div class="formula-block__formulas">
              <var>Points = A * (B - P)<sup>C</sup> or </var>
              <var>Points = A * (P - B)<sup>C</sup></var>
            </div>
            <p>Where A, B, C are coefficients and P is the performance/result by the athlete, seconds (running),
              metres (throwing), or centimetres (jumping).</p>
          </div>
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>Sport object</th>
                <th>Coefficient A</th>
                <th>Coefficient B</th>
                <th>Coefficient C</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="sport in sports">
                <td>{{ sport.name }}</td>
                <td>{{ sport.coefficientA }}</td>
                <td>{{ sport.coefficientB }}</td>
                <td>{{ sport.coefficientC }}</td>
              </tr>
            </tbody>
          </table>
          <p>Source: <a href="https://en.wikipedia.org/wiki/Decathlon#Points_system">Wikipedia</a></p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/Navbar";

export default {
  name: "home",
  components: {
    Navbar
  },
  data() {
    return {
      sports: null,
      chosenSport: null,
      chosenResult: null,
      pointScore: {
        points: 0,
        sport: {
          coefficientA: null,
          coefficientB: null,
          coefficientC: null
        }
      }
    };
  },
  mounted() {
    fetch('http://localhost:8080/api/sport/getAll').then(response => {
      response.json().then(data => {
        this.sports = data;
        this.chosenSport = this.sports[0];
      });
    });
  },
  methods: {
    postData() {
      const pointScore = {
        sport: this.chosenSport,
        result: this.chosenResult
      };

      fetch("http://localhost:8080/api/pointScore/getPoints", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body:  JSON.stringify(pointScore)
      })
        .then(response => response.json())
        .then(data => {
          this.pointScore = data;
        })
        .catch(error => {
          console.error('Request failure: ', error);
        });
    },
    submit() {
      this.postData();
    }
  }
};
</script>

<style lang="less" scoped>
  .info-column {
    padding-left: 2em;
    padding-right: 2em;
  }

  .card {
    margin-bottom: 2em;
  }

  .formula-block {
    margin-bottom: 1.5em;

    &__formulas {
      font-size: 1.25em;
      margin-bottom: 0.5em;
    }
  }
</style>