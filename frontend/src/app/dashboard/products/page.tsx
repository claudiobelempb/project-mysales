'use client';

import { ButtonRoot, ButtonText } from '@/components/ButtonRoot';
import { Header } from '@/components/header';
import {
  InputDefault,
  InputLabel,
  InputRoot,
  InputTextArea
} from '@/components/InputRoot';
import { ProductResponse } from '@/http/response/ProductResponse';
import { ProductCreateService } from '@/services/product/ProductCreateService';
import { useState } from 'react';

export default function Products() {
  const [sku, setSku] = useState('');
  const [price, setPrice] = useState(0);
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = () => {
    const product: ProductResponse = {
      sku,
      price,
      name,
      description
    };

    ProductCreateService(product)
      .then(response => console.log('ProductCreateService =>', response))
      .catch(erro => console.log(erro));

    // console.log('Products =>', product);
  };

  return (
    <div
      className={`
      h-screen
      
    `}
    >
      <Header
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />
      <div className='mt-7'>
        <h1>Cadastro de Produtos</h1>
        <div className='flex flex-col gap-2 mt-7'>
          <div className='flex flex-col gap-2 lg:flex-row'>
            <InputRoot className='w-full'>
              <InputLabel>SKU: *</InputLabel>
              <InputDefault
                placeholder='Digite o SKU do produto'
                type='text'
                value={sku}
                onChange={e => setSku(e.target.value)}
              />
            </InputRoot>
            <InputRoot className='w-full'>
              <InputLabel>Preço: *</InputLabel>
              <InputDefault
                placeholder='Digite o Preço do produto'
                type='text'
                value={price}
                onChange={e => setPrice(parseFloat(e.target.value))}
              />
            </InputRoot>
          </div>
          <InputRoot>
            <InputLabel>Nome: *</InputLabel>
            <InputDefault
              placeholder='Digite o Nome do produto'
              type='text'
              value={name}
              onChange={e => setName(e.target.value)}
            />
          </InputRoot>

          <InputRoot>
            <InputLabel>Descrição: *</InputLabel>
            <InputTextArea
              cols={10}
              rows={6}
              placeholder='Digite a Descrição detalhada do produto'
              className='resize-none'
              value={description}
              onChange={e => setDescription(e.target.value)}
            />
          </InputRoot>
          <ButtonRoot
            onClick={handleSubmit}
            className='bg-green-500 hover:bg-green-400'
          >
            <ButtonText className='text-black hover:text-black'>
              Salvar
            </ButtonText>
          </ButtonRoot>
        </div>
      </div>
    </div>
  );
}
