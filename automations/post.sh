curl -X POST http://localhost:8080/clients \
-H "Content-Type:application/json" \
-d '{"name": "Bruno Campos"}' -v | jq